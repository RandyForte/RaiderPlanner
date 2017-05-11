package Model;

import Controller.XMLcontroller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * PearPlanner
 * Created by Team BRONZE on 4/27/17
 */
public class HubFile implements Serializable
{
    // private data
    private ArrayList<VersionControlEntity> assets = new ArrayList<VersionControlEntity>();
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<ExtensionApplication> extensions = new ArrayList<ExtensionApplication>();
    private ArrayList<VersionControlEntity> updates = new ArrayList<VersionControlEntity>();
    private int version;
    private int semester;
    private int year;
    private boolean updateFile;
    private String semesterName;
    private String semesterUID;
    private MultilineString semesterDetails;

    // public methods

    // getters
    public ArrayList<Module> getModules()
    {
        // initial set up code below - check if this needs updating
        return modules;
    }

    public ArrayList<ExtensionApplication> getExtensions()
    {
        // initial set up code below - check if this needs updating
        return extensions;
    }

    public ArrayList<VersionControlEntity> getUpdates()
    {
        // initial set up code below - check if this needs updating
        return updates;
    }

    public int getVersion()
    {
        // initial set up code below - check if this needs updating
        return version;
    }

    public int getSemester()
    {
        // initial set up code below - check if this needs updating
        return semester;
    }

    public int getYear()
    {
        // initial set up code below - check if this needs updating
        return year;
    }

    public String getSemesterName()
    {
        return semesterName;
    }

    public String getSemesterUID()
    {
        return semesterUID;
    }

    public MultilineString getSemesterDetails()
    {
        return semesterDetails;
    }

    public boolean isUpdate()
    {
        return updateFile;
    }

    @Override
    public String toString()
    {
        return "HubFile for " + Integer.toString(year) + " semester: " + Integer.toString(semester) + " | Module Count: " +
                Integer.toString(modules.size());
    }
    // constructors

    /**
     * Constructor for new Study Profile
     *
     * @param v
     * @param y
     * @param s
     * @param m
     * @param a
     */
    public HubFile(int v, int y, int s, ArrayList<Module> m, ArrayList<VersionControlEntity> a)
    {
        version = v;
        year = y;
        semester = s;
        modules = (ArrayList<Module>) m.clone();
        assets = (ArrayList<VersionControlEntity>) a.clone();
        updateFile = false;
    }


    public HubFile(int v, int y, int s, ArrayList<Module> m, ArrayList<VersionControlEntity> a, String n,
                   MultilineString d, String u)
    {
        this(v, y, s, m, a);
        semesterName = n;
        semesterDetails = d;
        semesterUID = u;
    }

    /**
     * Constructor for update
     *
     * @param v
     * @param e
     * @param u
     */
    public HubFile(int v, ArrayList<ExtensionApplication> e, ArrayList<VersionControlEntity> u)
    {
        version = v;
        extensions = (ArrayList<ExtensionApplication>) e.clone();
        updates = (ArrayList<VersionControlEntity>) u.clone();
        updateFile = true;
    }


    // schemas
    // note, for the time being these are hard coded into the code
    // long term, these would be imported from a settings file

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_ROOT;

    static
    {
        SCHEMA_ROOT = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_ROOT.put("hubfile", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_NEW_STUDYPROFILE;

    static
    {
        SCHEMA_NEW_STUDYPROFILE = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_NEW_STUDYPROFILE.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_NEW_STUDYPROFILE.put("assets", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_NEW_STUDYPROFILE.put("studyProfile", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_UPDATE_FILE;

    static
    {
        SCHEMA_UPDATE_FILE = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_UPDATE_FILE.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_UPDATE_FILE.put("extensions", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_UPDATE_FILE.put("updates", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_ASSETS;

    static
    {
        SCHEMA_ASSETS = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_ASSETS.put("persons", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_ASSETS.put("buildings", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_ASSETS.put("rooms", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_ASSETS.put("timetableEventTypes", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_STUDYPROFILE;

    static
    {
        SCHEMA_STUDYPROFILE = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_STUDYPROFILE.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_STUDYPROFILE.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_STUDYPROFILE.put("uid", XMLcontroller.ImportAs.STRING);
        SCHEMA_STUDYPROFILE.put("year", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_STUDYPROFILE.put("semester", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_STUDYPROFILE.put("modules", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_PERSON;

    static
    {
        SCHEMA_PERSON = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_PERSON.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_PERSON.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_PERSON.put("uid", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("givenNames", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("familyName", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("salutation", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("email", XMLcontroller.ImportAs.STRING);
        SCHEMA_PERSON.put("familyNameLast", XMLcontroller.ImportAs.BOOLEAN);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_BUILDING;

    static
    {
        SCHEMA_BUILDING = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_BUILDING.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_BUILDING.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_BUILDING.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_BUILDING.put("uid", XMLcontroller.ImportAs.STRING);
        SCHEMA_BUILDING.put("code", XMLcontroller.ImportAs.STRING);
        SCHEMA_BUILDING.put("latitude", XMLcontroller.ImportAs.DOUBLE);
        SCHEMA_BUILDING.put("longitude", XMLcontroller.ImportAs.DOUBLE);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_ROOM;

    static
    {
        SCHEMA_ROOM = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_ROOM.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_ROOM.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_ROOM.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_ROOM.put("uid", XMLcontroller.ImportAs.STRING);
        SCHEMA_ROOM.put("building", XMLcontroller.ImportAs.STRING);
        SCHEMA_ROOM.put("roomNumber", XMLcontroller.ImportAs.STRING);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_TIMETABLE_EVENT_TYPE;

    static
    {
        SCHEMA_TIMETABLE_EVENT_TYPE = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_TIMETABLE_EVENT_TYPE.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT_TYPE.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_TIMETABLE_EVENT_TYPE.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_TIMETABLE_EVENT_TYPE.put("uid", XMLcontroller.ImportAs.STRING);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_MODULE;

    static
    {
        SCHEMA_MODULE = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_MODULE.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_MODULE.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_MODULE.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_MODULE.put("uid", XMLcontroller.ImportAs.STRING);
        SCHEMA_MODULE.put("organiser", XMLcontroller.ImportAs.STRING);
        SCHEMA_MODULE.put("moduleCode", XMLcontroller.ImportAs.STRING);
        SCHEMA_MODULE.put("timetable", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_MODULE.put("assignments", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_COURSEWORK;

    static
    {
        SCHEMA_COURSEWORK = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_COURSEWORK.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_COURSEWORK.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_COURSEWORK.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_COURSEWORK.put("uid", XMLcontroller.ImportAs.STRING);

        SCHEMA_COURSEWORK.put("weighting", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_COURSEWORK.put("setBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_COURSEWORK.put("markedBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_COURSEWORK.put("reviewedBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_COURSEWORK.put("marks", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_COURSEWORK.put("startDate", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_COURSEWORK.put("deadline", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_COURSEWORK.put("extensions", XMLcontroller.ImportAs.NODELIST);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_EXAM;

    static
    {
        SCHEMA_EXAM = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_EXAM.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAM.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_EXAM.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_EXAM.put("uid", XMLcontroller.ImportAs.STRING);

        SCHEMA_EXAM.put("resit", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAM.put("timeslot", XMLcontroller.ImportAs.NODELIST);
        SCHEMA_EXAM.put("weighting", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_EXAM.put("setBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAM.put("markedBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAM.put("reviewedBy", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAM.put("marks", XMLcontroller.ImportAs.INTEGER);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_TIMETABLE_EVENT;

    static
    {
        SCHEMA_TIMETABLE_EVENT = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_TIMETABLE_EVENT.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_TIMETABLE_EVENT.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_TIMETABLE_EVENT.put("uid", XMLcontroller.ImportAs.STRING);

        SCHEMA_TIMETABLE_EVENT.put("date", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT.put("room", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT.put("lecturer", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT.put("timetableEventType", XMLcontroller.ImportAs.STRING);
        SCHEMA_TIMETABLE_EVENT.put("duration", XMLcontroller.ImportAs.INTEGER);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_EVENT;

    static
    {
        SCHEMA_EVENT = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_EVENT.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_EVENT.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_EVENT.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_EVENT.put("uid", XMLcontroller.ImportAs.STRING);

        SCHEMA_EVENT.put("date", XMLcontroller.ImportAs.STRING);
    }

    public static HashMap<String, XMLcontroller.ImportAs> SCHEMA_EXAMEVENT;

    static
    {
        SCHEMA_EXAMEVENT = new HashMap<String, XMLcontroller.ImportAs>();
        SCHEMA_EXAMEVENT.put("name", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAMEVENT.put("details", XMLcontroller.ImportAs.MULTILINESTRING);
        SCHEMA_EXAMEVENT.put("version", XMLcontroller.ImportAs.INTEGER);
        SCHEMA_EXAMEVENT.put("uid", XMLcontroller.ImportAs.STRING);

        SCHEMA_EXAMEVENT.put("date", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAMEVENT.put("room", XMLcontroller.ImportAs.STRING);
        SCHEMA_EXAMEVENT.put("duration", XMLcontroller.ImportAs.INTEGER);
    }

}
