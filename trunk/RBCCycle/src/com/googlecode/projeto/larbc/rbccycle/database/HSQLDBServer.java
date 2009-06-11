package com.googlecode.projeto.larbc.rbccycle.database;

/**
 * HSQLDBserver.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garca.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 04/07/2007
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import jcolibri.util.FileIO;

import org.hsqldb.Server;
import org.hsqldb.util.SqlFile;

/**
 * Creates a data base server with the tables for the examples/tests using the HSQLDB library.
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class HSQLDBServer
{
    static boolean initialized = false;

    private static Server server;

    /**
     * Initialize the server
     */
    public static void init()
    {
        if (initialized)
            return;
        org.apache.commons.logging.LogFactory.getLog(HSQLDBServer.class).info("Creating data base ...");

        server = new Server();
        server.setDatabaseName(0, "Larbc");
        server.setDatabasePath(0, "mem:Residence;sql.enforce_strict_size=true");
        
        server.setLogWriter(null);
        server.setErrWriter(null);
        server.setSilent(true);
        server.start();

        initialized = true;
        try
        {
            Class.forName("org.hsqldb.jdbcDriver");

            PrintStream out = new PrintStream(new ByteArrayOutputStream());
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/Larbc", "sa", "");
            SqlFile file = new SqlFile(new File(FileIO.findFile("com/googlecode/projeto/larbc/rbccycle/databaseconfig/Database.sql").getFile()),false,new HashMap());
            file.execute(conn,out,out, true);
            org.apache.commons.logging.LogFactory.getLog(HSQLDBServer.class).info("Data base generation finished");
            
        } catch (Exception e)
        {
            org.apache.commons.logging.LogFactory.getLog(HSQLDBServer.class).error(e);
        }

    }

    /**
     * Shutdown the server
     */
    public static void shutDown()
    {

        if (initialized)
        {
            server.stop();
            initialized = false;
        }
    }

    /**
     * Testing method
     */
    public static void main(String[] args)
    {
        HSQLDBServer.init();
        HSQLDBServer.shutDown();
        System.exit(0);
        
    }

}

