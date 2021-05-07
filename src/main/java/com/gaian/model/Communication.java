package com.gaian.model;

import com.gaian.model.request.engagement.Frs.CommunicationType;
import lombok.Data;

import java.util.Set;

import static com.gaian.model.request.engagement.Frs.CommunicationType.BROADCAST;

@Data
public class Communication {

    private CommunicationType type = BROADCAST;

    private Set<String> ggsIds;
}
