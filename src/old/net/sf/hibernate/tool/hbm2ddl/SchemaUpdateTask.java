//$Id: SchemaUpdateTask.java,v 1.4 2005/08/24 04:33:28 nick Exp $
package net.sf.hibernate.tool.hbm2ddl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.cfg.NamingStrategy;
import net.sf.hibernate.util.ArrayHelper;
import net.sf.hibernate.util.ReflectHelper;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;

/**
 * An Ant task for <tt>SchemaUpdate</tt>.
 * 
 * <pre>
 * 
 *  
 *   &lt;taskdef name=&quot;schemaupdate&quot;
 *       classname=&quot;net.sf.hibernate.tool.hbm2ddl.SchemaUpdateTask&quot;
 *       classpathref=&quot;class.path&quot;/&gt;
 *  
 *   &lt;schemaupdate
 *       properties=&quot;${build.classes.dir}/hibernate.properties&quot;
 *       quiet=&quot;no&quot;
 *       &lt;fileset dir=&quot;${build.classes.dir}&quot;&gt;
 *           &lt;include name=&quot;*.hbm.xml&quot;/&gt;
 *       &lt;/fileset&gt;
 *   &lt;/schemaupdate&gt;
 *   
 *  
 * </pre>
 * 
 * @see SchemaUpdate
 * @author Rong C Ou, Gavin King
 */
public class SchemaUpdateTask extends MatchingTask {

    private List fileSets = new LinkedList();

    private File propertiesFile = null;

    private String configurationFile = null;

    private boolean quiet = false;

    private String namingStrategy = null;

    public void addFileset(FileSet set) {
        fileSets.add(set);
    }

    /**
     * Set a properties file
     * 
     * @param propertiesFile
     *            the properties file name
     */
    public void setProperties(File propertiesFile) {
        if (!propertiesFile.exists()) {
            throw new BuildException("Properties file: " + propertiesFile
                    + " does not exist.");
        }

        log("Using properties file " + propertiesFile, Project.MSG_DEBUG);
        this.propertiesFile = propertiesFile;
    }

    /**
     * Set a <literal>.cfg.xml </literal> file
     * 
     * @param configurationFile
     *            the file name
     */
    public void setConfig(String configurationFile) {
        this.configurationFile = configurationFile;
    }

    /**
     * Enable "quiet" mode. The schema will not be written to standard out.
     * 
     * @param quiet
     *            true to enable quiet mode
     */
    public void setQuiet(boolean quiet) {
        this.quiet = quiet;
    }

    /**
     * Execute the task
     */
    public void execute() throws BuildException {
        try {
            Configuration cfg = getConfiguration();
            getSchemaUpdate(cfg).execute(!quiet);
        } catch (HibernateException e) {
            throw new BuildException("Schema text failed: " + e.getMessage(), e);
        } catch (FileNotFoundException e) {
            throw new BuildException("File not found: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new BuildException("IOException : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new BuildException(e);
        }
    }

    private String[] getFiles() {

        List files = new LinkedList();
        for (Iterator i = fileSets.iterator(); i.hasNext();) {

            FileSet fs = (FileSet) i.next();
            DirectoryScanner ds = fs.getDirectoryScanner(project);

            String[] dsFiles = ds.getIncludedFiles();
            for (int j = 0; j < dsFiles.length; j++) {
                File f = new File(dsFiles[j]);
                if (!f.isFile()) {
                    f = new File(ds.getBasedir(), dsFiles[j]);
                }

                files.add(f.getAbsolutePath());
            }
        }

        return (String[]) files.toArray(ArrayHelper.EMPTY_STRING_ARRAY);
    }

    private Configuration getConfiguration() throws Exception {
        Configuration cfg = new Configuration();
        if (namingStrategy != null)
            cfg.setNamingStrategy((NamingStrategy) ReflectHelper.classForName(
                    namingStrategy).newInstance());
        if (configurationFile != null)
            cfg.configure(configurationFile);

        String[] files = getFiles();
        for (int i = 0; i < files.length; i++) {
            String filename = files[i];
            if (filename.endsWith(".jar")) {
                cfg.addJar(new File(filename));
            } else {
                cfg.addFile(filename);
            }
        }
        return cfg;
    }

    private SchemaUpdate getSchemaUpdate(Configuration cfg)
            throws HibernateException, IOException {
        SchemaUpdate schemaUpdate;
        if (propertiesFile == null) {
            schemaUpdate = new SchemaUpdate(cfg);
        } else {
            Properties properties = new Properties();
            properties.load(new FileInputStream(propertiesFile));
            schemaUpdate = new SchemaUpdate(cfg, properties);
        }
        return schemaUpdate;
    }

    public void setNamingStrategy(String namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

}

