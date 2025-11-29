package test.utilDb;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Connexion
 *
 * Cette classe permet de gérer la connexion à une base de données PostgreSQL.
 * Elle fournit deux méthodes principales :
 *   1) createConnection() : ouvre une connexion si elle n'existe pas encore
 *   2) destroyConnection() : ferme la connexion si elle est ouverte
 *
 * Utilisation typique :
 *   Connexion con = new Connexion();
 *   con.createConnection();
 *   // utiliser con.getConnection() pour exécuter des requêtes
 *   con.destroyConnection();
 */
public class Connexion {

    // -------------------------
    // Attributs de connexion
    // -------------------------

    // Nom d'utilisateur pour PostgreSQL
    private String user = "postgres";

    // Mot de passe pour PostgreSQL
    private String password = "postgres";

    // Nom de la base de données
    private String databaseName = "testFramework";

    // Objet java.sql.Connection
    private Connection connection;

    // URL de connexion JDBC pour PostgreSQL
    // Format : jdbc:postgresql://<host>:<port>/<database>
    private String url = "jdbc:postgresql://localhost:5432/" + databaseName;

    // -------------------------
    // Constructeurs
    // -------------------------

    public Connexion() {
        // constructeur par défaut
    }

    public Connexion(String user, String password, String databaseName) {
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;
        this.url = "jdbc:postgresql://localhost:5432/" + databaseName;
    }

    // -------------------------
    // Méthodes
    // -------------------------

    /**
     * Ouvre la connexion à la base de données si elle n'est pas déjà ouverte.
     *
     * @throws SQLException si la connexion échoue
     */
    public void createConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Charger le driver PostgreSQL
                Class.forName("org.postgresql.Driver");

                // Créer la connexion
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Connexion à PostgreSQL établie avec succès !");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver PostgreSQL introuvable !");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connexion à la base : " + e.getMessage());
                throw e; // on relance l'exception pour le gérer en dehors
            }
        } else {
            System.out.println("La connexion est déjà ouverte.");
        }
    }

    /**
     * Ferme la connexion si elle est ouverte.
     */
    public void destroyConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée avec succès.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            } finally {
                connection = null; // s'assure que l'objet est mis à null
            }
        } else {
            System.out.println("Aucune connexion à fermer.");
        }
    }

    /**
     * Getter pour la connexion
     *
     * Permet d'utiliser la connexion pour exécuter des requêtes SQL
     */
    public Connection getConnection() {
        return connection;
    }

}
