package in.geobullet.csci_4176_project.db.Classes;

import java.util.Date;

import in.geobullet.csci_4176_project.db.Utils.DateUtil;


/* Class that corresponds to the Poster database table */

public class Poster {

    private int id;
    private Date created;
    private int createdByUserId;
    private String title;
    private PosterType posterType;
    private String address;
    private String city;
    private String stateProv;
    private String details;
    private Date startDate;
    private Date endDate;
    private Date startTime;
    private Date endTime;
    private String photoName;
    private String iconName;

    public Poster() {


    }

    public Poster(int id, Date created, int createdByUserId, String title, PosterType posterType, String address, String city, String stateProv, String details, Date startDate, Date endDate, Date startTime, Date endTime, String photoName) {
        this.id = id;
        this.created = created;
        this.createdByUserId = createdByUserId;
        this.title = title;
        this.posterType = posterType;
        this.address = address;
        this.city = city;
        this.stateProv = stateProv;
        this.details = details;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.photoName = photoName;
        iconName = photoName.substring(0, photoName.lastIndexOf(".")) +"_icon.png";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PosterType getPosterType() {
        return posterType;
    }

    public void setPosterType(PosterType posterType) {
        this.posterType = posterType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", created=" + DateUtil.formatDate(created) +
                ", createdByUserId=" + createdByUserId +
                ", title='" + title + '\'' +
                ", posterType=" + posterType +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stateProv='" + stateProv + '\'' +
                ", details='" + details + '\'' +
                ", startDate=" + DateUtil.formatDate(startDate) +
                ", endDate=" + DateUtil.formatDate(endDate) +
                ", startTime=" + DateUtil.formatTime(startTime) +
                ", endTime=" + DateUtil.formatTime(endTime) +
                ", photoName='" + photoName + '\'' +
                '}';
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}


