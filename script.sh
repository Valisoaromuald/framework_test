#!/bin/bash

# Emplacement du projet
PROJECT_DIR="$HOME/Documents/S5/MR_Naina/framework/framework_test"

# Emplacement du tomcat
TOMCAT="$HOME/Documents/S5/apache-tomcat-10.1.28"

# Nom de l'application dans webapps
APP_NAME="framework"

# Dossiers source
SRC_JAVA="$PROJECT_DIR/src/java"
SRC_WEBAPPS="$PROJECT_DIR/src/webapps"
LIB_DIR="$PROJECT_DIR/lib"

# Dossiers destination
BIN_CLASSES="$PROJECT_DIR/bin/WEB-INF/classes"
DEST_WEBAPPS="$TOMCAT/webapps/$APP_NAME"

echo "=== COMPILATION + DEPLOIEMENT ==="

# 1) Nettoyer les classes compilées
echo "[1] Nettoyage des classes..."
rm -rf "$BIN_CLASSES"
mkdir -p "$BIN_CLASSES"

# 2) Construire le classpath (pour compiler)
CP="$LIB_DIR/frontServlet.jar:$TOMCAT/lib/servlet-api.jar:$BIN_CLASSES"

# 3) Compiler les fichiers Java
echo "[2] Compilation des fichiers .java..."
find "$SRC_JAVA" -name "*.java" > sources.txt

javac -parameters -cp "$CP" -d "$BIN_CLASSES" @sources.txt

if [ $? -ne 0 ]; then
    echo "❌ ERREUR DE COMPILATION"
    exit 1
fi

echo "✔ Compilation terminée"

# 4) Nettoyer ancien déploiement Tomcat
echo "[3] Nettoyage ancien déploiement..."
rm -rf "$DEST_WEBAPPS"
mkdir -p "$DEST_WEBAPPS"

# 5) Copier les fichiers web (jsp, html, png…)
echo "[4] Copie des fichiers web..."
cp -r "$SRC_WEBAPPS/"* "$DEST_WEBAPPS/"

# 6) Copier WEB-INF (web.xml + classes)
echo "[5] Copie de WEB-INF..."
mkdir -p "$DEST_WEBAPPS/WEB-INF"
cp -r "$PROJECT_DIR/bin/WEB-INF/"* "$DEST_WEBAPPS/WEB-INF/"

# 7) Copier les JAR dans WEB-INF/lib
echo "[6] Copie des JAR dans WEB-INF/lib..."
mkdir -p "$DEST_WEBAPPS/WEB-INF/lib"
cp "$LIB_DIR/"*.jar "$DEST_WEBAPPS/WEB-INF/lib/"

echo "=== DEPLOIEMENT TERMINE ==="
echo "Application deployée dans : $DEST_WEBAPPS"
echo "JAR disponibles dans : $DEST_WEBAPPS/WEB-INF/lib/"
