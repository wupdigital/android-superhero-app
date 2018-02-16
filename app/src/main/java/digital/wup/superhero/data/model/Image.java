package digital.wup.superhero.data.model;


import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Image {
    @ColumnInfo(name = "path")
    @SerializedName("path")
    private String path;
    @ColumnInfo(name = "extension")
    @SerializedName("extension")
    private String extension;

    public Image() {

    }

    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
