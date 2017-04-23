package pl.sternik.weekend.ac.services;

import java.util.List;
import pl.sternik.weekend.ac.services.NotificationServiceImpl.NotificationMessage;

public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
    List<NotificationMessage> getNotificationMessages();
}
