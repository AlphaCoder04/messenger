package database;

import javax.persistence.*;

@Entity
@Table(name = "Videoanrufe")
public class Videoanrufe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideoanrufID")
    private int videoanrufID;
    @Column(name = "AnrufID")
    private int AnrufID;
    @Column(name = "VideostreamURL")
    private String videoStreamURL;
    @Column(name = "KameraAkZviert")
    private boolean videoAktiviert;
    @Column(name = "MikrofonAkZviert")
    private boolean MikrofonAktiviert;

    public Videoanrufe(int AnrufID, String videoStreamURL, boolean videoAktiviert, boolean MikrofonAktiviert) {
        this.AnrufID = AnrufID;
        this.videoStreamURL = videoStreamURL;
        this.videoAktiviert = videoAktiviert;
        this.MikrofonAktiviert = MikrofonAktiviert;
    }
    public int getVideoanrufID() {
        return videoanrufID;
    }
    public void setVideoanrufID(int videoanrufID) {
        this.videoanrufID = videoanrufID;
    }
    public int getAnrufID() {
        return AnrufID;
    }
    public void setAnrufID(int AnrufID) {
        this.AnrufID = AnrufID;
    }
    public String getVideoStreamURL() {
        return videoStreamURL;
    }
    public void setVideoStreamURL(String videoStreamURL) {
        this.videoStreamURL = videoStreamURL;
    }
    public boolean isVideoAktiviert() {
        return videoAktiviert;
    }
    public void setVideoAktiviert(boolean videoAktiviert) {
        this.videoAktiviert = videoAktiviert;
    }
    public boolean isMikrofonAktiviert() {
        return MikrofonAktiviert;
    }
    public void setMikrofonAktiviert(boolean MikrofonAktiviert) {
        this.MikrofonAktiviert = MikrofonAktiviert;
    }
}
