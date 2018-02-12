
package com.project.service;

import com.project.dto.MessageDTO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public static final String NOTIFY_MSG_SESSION_KEY = "notificationMessages";

    @Autowired
    private HttpSession httpSession;

    public void addInfoMessage(String msg) {
        addNotificationMessage(MessageDTO.MessageDTOType.INFO, msg);
    }

    public void addSuccessMessage(String msg){
        addNotificationMessage(MessageDTO.MessageDTOType.SUCCESS, msg);
    }

    public void addWarnMessage(String msg){
        addNotificationMessage(MessageDTO.MessageDTOType.WARN, msg);
    }

    public void addErrorMessage(String msg) {
        addNotificationMessage(MessageDTO.MessageDTOType.ERROR, msg);
    }

    private void addNotificationMessage(MessageDTO.MessageDTOType type, String msg) {
        List<MessageDTO> notifyMessages = (List<MessageDTO>) httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
        if (notifyMessages == null) {
            notifyMessages = new ArrayList<MessageDTO>();
        }
        notifyMessages.add(new MessageDTO(type, msg));
        httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);
    }
}



