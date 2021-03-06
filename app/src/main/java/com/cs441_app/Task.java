package com.cs441_app;

public class Task {


    private long day;
    private long month;
    private long year;

    private long hour;
    private long min;

    private long category;
    private String title;
    private String description;
    private String location;
    private boolean share;
    private User user;
    private Group group;

    private String id;
    public Task(){

    }

    public Task(long Day, long Month, long Year){
        day = Day;
        month = Month;
        year = Year;
    }

    public Task(long Day,long Month, long Year, long Hour, long Min, long Category, String Title, String Description, String Location, boolean Share, User User){
        day = Day;
        month = Month;
        year = Year;
        hour = Hour;
        min = Min;
        category = Category;
        title = Title;
        description = Description;
        location = Location;
        share = Share;
        user = User;
    }

    public Task(long Day,long Month, long Year, long Hour, long Min, long Category, String Title, String Description, String Location, boolean Share, User User, String ID){
        day = Day;
        month = Month;
        year = Year;
        hour = Hour;
        min = Min;
        category = Category;
        title = Title;
        description = Description;
        location = Location;
        share = Share;
        user = User;
        id = ID;
    }

    @Override
    public String toString() {
        String print = title + "             ";
        if(hour > 11){
            if(hour == 12) {
                print = print + Long.toString(hour) + ":" + Long.toString(min) + "pm";
            }
            else
                print = print + Long.toString(hour - 12) + ":" + Long.toString(min) + "pm";
        }
        else
            print = print + Long.toString(hour) + ":" + Long.toString(min) + "am";
        if(share == true){
            print = print + "    \n(Synced from " + group.getName() + ")";
        }
        return print;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }
}
