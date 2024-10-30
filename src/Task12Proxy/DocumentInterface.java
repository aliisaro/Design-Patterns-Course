package Task12Proxy;

import java.time.LocalDate;

public interface DocumentInterface {
    String getContent(User user);

    LocalDate getCreationDate();
}
