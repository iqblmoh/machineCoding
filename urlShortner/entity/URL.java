package urlShortner.entity;

import java.time.LocalDateTime;


public class URL {
    private Integer id;

    private String longUrl;

    private String shortUrl;

    private Boolean isAccessed;

    private LocalDateTime expiredBy;

    private Client client;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Boolean getAccessed() {
        return isAccessed;
    }

    public void setAccessed(Boolean accessed) {
        isAccessed = accessed;
    }

    public LocalDateTime getExpiredBy() {
        return expiredBy;
    }

    public void setExpiredBy(LocalDateTime expiredBy) {
        this.expiredBy = expiredBy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", isAccessed=" + isAccessed +
                ", expiredBy=" + expiredBy +
                ", client=" + client +
                '}';
    }
}
