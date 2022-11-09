package com.example.mobile4d.networking;

import androidx.annotation.NonNull;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Title {

    @SerializedName("message")
    @Expose
    private List<String> message = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return "Title{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}