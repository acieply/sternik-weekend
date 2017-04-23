package pl.sternik.weekend.ac.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NotificationServiceImpl implements NotificationService {

	public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

	@Autowired
	private HttpSession httpSession;

	@Override
	public void addInfoMessage(String msg) {
		addNotificationMessage(NotificationMessageType.INFO, msg);
	}

	@Override
	public void addErrorMessage(String msg) {
		addNotificationMessage(NotificationMessageType.ERROR, msg);
	}

	@Override
	public List<NotificationMessage> getNotificationMessages() {
		List<NotificationMessage> notifyMessages = (List<NotificationMessage>) httpSession
				.getAttribute(NOTIFY_MSG_SESSION_KEY);
		httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, new ArrayList<NotificationMessage>());
		return notifyMessages;
	}

	private void addNotificationMessage(NotificationMessageType type, String msg) {
		List<NotificationMessage> notifyMessages = (List<NotificationMessage>) httpSession
				.getAttribute(NOTIFY_MSG_SESSION_KEY);
		if (notifyMessages == null) {
			notifyMessages = new ArrayList<NotificationMessage>();
		}
		notifyMessages.add(new NotificationMessage(type, msg));
		httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);
	}

	public enum NotificationMessageType {
		INFO, ERROR
	}

	public class NotificationMessage {
		NotificationMessageType type;
		String text;

		public NotificationMessage(NotificationMessageType type, String text) {
			this.type = type;
			this.text = text;
		}

		public NotificationMessageType getType() {
			return type;
		}

		public String getText() {
			return text;
		}
	}
}