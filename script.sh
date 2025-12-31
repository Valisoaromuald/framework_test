#!/bin/bash

# Argument pour arrêt rapide du script
one=$1

# === Couleurs ===
GREEN='\033[0;32m'
RED='\033[0;31m'
ORANGE='\033[0;33m'
BLUE='\033[0;34m'
NC='\033[0m'

# === Chemins de base ===
BUILD_PATH="bin"
LIBRARY_PATH="lib"
TOMCAT_PATH="$HOME/Documents/S5/apache-tomcat-10.1.28"
WEBAPPS_PATH_LOCAL="src/webapps"
WEBAPPS_PATH_SERVER="webapps"
WAR_NAME="Framework"
JAR_FILE="frontServlet.jar"

# === Nettoyage des / finaux ===
BUILD_PATH="${BUILD_PATH%/}"
LIBRARY_PATH="${LIBRARY_PATH%/}"
WEBAPPS_PATH_LOCAL="${WEBAPPS_PATH_LOCAL%/}"

# === Option de sortie rapide ===
if [ "$one" = "-1" ]; then
    echo -e "$RED\t...Fermeture du Tomcat$NC\n"
    "$TOMCAT_PATH/bin/shutdown.sh"
    exit 1
fi

# === Copie des librairies ===
echo -e "$ORANGE\t...Copie de lib dans WEB-INF$NC\n"

if [ ! -d "$BUILD_PATH/WEB-INF/lib" ]; then
    echo "Création du dossier $BUILD_PATH/WEB-INF/lib..."
    mkdir -p "$BUILD_PATH/WEB-INF/lib"
fi

# Copier toutes les librairies
cp "$LIBRARY_PATH"/*.jar "$BUILD_PATH/WEB-INF/lib/" 2>/dev/null

if [ $? -eq 0 ]; then
    echo -e "${GREEN}\tCopie des librairies réussie${NC}\n"
else
    echo -e "${RED}\tAucune librairie copiée ou erreur${NC}\n"
    exit 1
fi

# === Compilation ===
echo -e "$BLUE...Compilation du code Java$NC\n"

# Nettoyage uniquement des .class
rm -rf "$BUILD_PATH/WEB-INF/classes"
mkdir -p "$BUILD_PATH/WEB-INF/classes"

# Trouver tous les fichiers .java
find src/java -name "*.java" > source.txt

# Compilation
if javac -parameters -d "$BUILD_PATH/WEB-INF/classes" -cp "$BUILD_PATH/WEB-INF/lib/*" @source.txt; then
    echo -e "${GREEN}\tCompilation réussie${NC}\n"
else
    echo -e "${RED}\tCompilation échouée${NC}\n"
    rm source.txt
    exit 1
fi


rm source.txt

# === Copie des fichiers web (HTML, JSP, WEB-INF, etc.) ===
echo -e "${BLUE}...Copie du contenu du dossier WEBAPPS dans build${NC}\n"

if cp -R "$WEBAPPS_PATH_LOCAL"/* "$BUILD_PATH"/; then
    echo -e "${GREEN}\tCopie réussie${NC}\n"
else
    echo -e "${RED}\tErreur de copie${NC}\n"
    exit 1
fi

# === Création du fichier WAR ===
echo -e "${BLUE}...Création du fichier WAR${NC}\n"

cd "$BUILD_PATH" || exit 1
if jar -cvf "../$WAR_NAME.war" ./* > /dev/null; then
    echo -e "${GREEN}\tArchivage réussi${NC}\n"
else
    echo -e "${RED}\tErreur lors de l'archivage${NC}\n"
    exit 1
fi
cd ..

# === Déploiement dans Tomcat ===
echo -e "${BLUE}...Arrêt de Tomcat et nettoyage de l'ancien déploiement${NC}\n"

"$TOMCAT_PATH/bin/shutdown.sh"
sleep 3

rm -rf "$TOMCAT_PATH/$WEBAPPS_PATH_SERVER/$WAR_NAME"
rm -rf "$TOMCAT_PATH/work/Catalina/localhost/$WAR_NAME"

echo -e "${BLUE}...Déploiement du nouveau WAR${NC}\n"

if mv -f "$WAR_NAME.war" "$TOMCAT_PATH/$WEBAPPS_PATH_SERVER/"; then
    echo -e "${GREEN}\tDéploiement réussi${NC}\n"
else
    echo -e "${RED}\tDéploiement échoué${NC}\n"
    exit 1
fi

echo -e "${BLUE}...Démarrage de Tomcat${NC}\n"
"$TOMCAT_PATH/bin/startup.sh"
echo ""

# === Nettoyage final du dossier build ===
echo -e "${ORANGE}...Nettoyage du dossier ${BUILD_PATH} après déploiement${NC}\n"

# Supprime tout sauf le contenu essentiel de WEB-INF/classes et WEB-INF/lib
find "$BUILD_PATH" -mindepth 1 ! -path "$BUILD_PATH/WEB-INF" ! -path "$BUILD_PATH/WEB-INF/*" -exec rm -rf {} +

# Supprime tout dans WEB-INF sauf classes et lib
find "$BUILD_PATH/WEB-INF" -mindepth 1 ! -path "$BUILD_PATH/WEB-INF/classes" ! -path "$BUILD_PATH/WEB-INF/classes/*" \
     ! -path "$BUILD_PATH/WEB-INF/lib" ! -path "$BUILD_PATH/WEB-INF/lib/*" -exec rm -rf {} +

# Supprime les .java et fichiers temporaires
find "$BUILD_PATH" -type f \( -name "*.java" -o -name "*.log" -o -name "*.tmp" \) -delete

echo -e "${GREEN}\tNettoyage terminé — dossier ${BUILD_PATH} allégé${NC}\n"

echo -e "$ORANGE\t...Fin du script${NC}\n"
