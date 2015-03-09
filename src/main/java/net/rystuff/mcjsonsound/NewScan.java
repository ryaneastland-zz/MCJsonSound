package net.rystuff.mcjsonsound;

import com.google.gson.stream.JsonWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class NewScan
{
    public static String modid;
    public static Collection directories;
    public static File file;
    public static String[] ext;
    public static Collection files;
    public static String dir;
    public static List<String> dirs = new ArrayList<String>();
    public static String[] stringDirs;
    public static List<String> names = new ArrayList<String>();
    public static String[] stringNames;
    public static String[] dirSplit;
    public static String name;
    public static String lastName = null;
    public static JsonWriter writer;
    public static int testing;

    /**
     * @param modid  The modid specified in the gui or command line argument
     * @param sounds The sounds directory specified in the gui or command line argument
     * @param json   The json file specified in the gui or command line argument
     * @throws IOException
     */
    public NewScan(String modid, String sounds, String json) throws IOException
    {
        // Sets modid var
        NewScan.modid = modid;
        // Sets up JsonWriter
        writer = new JsonWriter(new FileWriter(json));
        // Makes a collection for files in specified dir
        directories = FileUtils.listFiles(new File(sounds), new String[]{"ogg"}, true);
        // For all files inside directories Collection
        for (Object path : directories)
        {
            // replaces backslashes with forward slashes in path
            path = StringUtils.replace(path.toString(), "\\", "/");
            // Gets removes "sounds/" from the path
            path = StringUtils.substringAfter(path.toString(), "sounds/");
            // removes .ogg from path and sets it as dir
            dir = StringUtils.replace(path.toString(), ".ogg", "");
            // adds the dir var to a dirs list
            dirs.add(dir);
            // spilts the dir var at the / and saves it to dirSlit 
            dirSplit = dir.split("/");
            // if dirSplit's length is 1
            if (dirSplit.length == 1)
            {
                name = dir.split("/")[0];
                if (!name.equals(lastName))
                {
                    names.add(name);
                }
                lastName = name;
            }
            // if dirSplit's length is 2
            if (dirSplit.length == 2)
            {
                name = dir.split("/")[1];
                if (!name.equals(lastName))
                {
                    names.add(name);
                }
                lastName = name;
            }
            // if dirSplit's length is 3
            if (dirSplit.length == 3)
            {
                name = dir.split("/")[2];
                if (!name.equals(lastName))
                {
                    names.add(name);
                }
                lastName = name;
            }
        }
        stringDirs = new String[dirs.size()];
        stringDirs = dirs.toArray(stringDirs);
        stringNames = new String[names.size()];
        stringNames = names.toArray(stringNames);
        writer.beginObject();
        writer.setIndent("    ");
        String lastLiving = null;
        String lastHurt = null;
        String lastDeath = null;
        name = null;
        for (String dir : stringDirs)
        {
            if (dir.split("/").length > 2)
            {
                name = dir.split("/")[1];
            }
            if (dir.toLowerCase().contains("living") && !name.equals(lastLiving))
            {
                writer.name(modid + ":" + name + ":" + "living");
                writer.beginObject();
                writer.name("category").value("hostile");
                writer.name("sounds").beginArray();
                for (String dir1 : dirs)
                {
                    if (dir1.contains(name) && dir1.toLowerCase().contains("living"))
                    {
                        writer.value(dir1);
                    }
                }
                writer.endArray();
                writer.endObject();
                lastLiving = name;
            }
            if (dir.toLowerCase().contains("hurt") && !name.equals(lastHurt))
            {
                writer.name(modid + ":" + name + ":" + "hurt");
                writer.beginObject();
                writer.name("category").value("hostile");
                writer.name("sounds").beginArray();
                for (String dir1 : dirs)
                {
                    if (dir1.contains(name) && dir1.toLowerCase().contains("hurt"))
                    {
                        writer.value(dir1);
                    }
                }
                writer.endArray();
                writer.endObject();
                lastHurt = name;
            }
            if (dir.toLowerCase().contains("death") && !name.equals(lastDeath))
            {
                writer.name(modid + ":" + name + ":" + "death");
                writer.beginObject();
                writer.name("category").value("hostile");
                writer.name("sounds").beginArray();
                for (String dir1 : dirs)
                {
                    if (dir1.contains(name) && dir1.toLowerCase().contains("death"))
                    {
                        writer.value(dir1);
                    }
                }
                writer.endArray();
                writer.endObject();
                lastDeath = name;
            }
        }
        writer.endObject();
        writer.close();
    }
}
