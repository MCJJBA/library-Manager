package com.org.notification.DTO;

public class EmpruntEvent {
    private Long empruntId;
    private Long userId;
    private Long bookId;
    private String eventType;
    private String timestamp;

    public EmpruntEvent() {
    }

    public Long getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Long empruntId) {
        this.empruntId = empruntId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
