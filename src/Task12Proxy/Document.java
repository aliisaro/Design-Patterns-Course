package Task12Proxy;

import java.time.LocalDate;

public class Document implements DocumentInterface {
    private String id;
    private LocalDate date;
    private String content;

    public Document(String id, LocalDate date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public LocalDate getCreationDate() {
        return date;
    }

    public String getDocumentId() {
        return id;
    }
}
