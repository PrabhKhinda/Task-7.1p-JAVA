package com.example.lostfoundapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Advert implements Parcelable {
    private long id;
    private String name;
    private String type;
    private String description;
    private String date;
    private String location;
    private String phone;

    public Advert(long id, String name, String type, String description, String date, String location, String phone) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.date = date;
        this.location = location;
        this.phone = phone;
    }

    protected Advert(Parcel in) {
        id = in.readLong();
        name = in.readString();
        type = in.readString();
        description = in.readString();
        date = in.readString();
        location = in.readString();
        phone = in.readString();
    }

    public static final Creator<Advert> CREATOR = new Creator<Advert>() {
        @Override
        public Advert createFromParcel(Parcel in) {
            return new Advert(in);
        }

        @Override
        public Advert[] newArray(int size) {
            return new Advert[size];
        }
    };

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(location);
        parcel.writeString(phone);
    }
}
