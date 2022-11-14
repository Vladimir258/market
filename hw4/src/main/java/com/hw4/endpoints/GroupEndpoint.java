package com.hw4.endpoints;

import com.hw4.services.GroupService;
import com.hw4.soap.groups.GetGroupByTitleRequest;
import com.hw4.soap.groups.GetGroupByTitleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class GroupEndpoint {
    private static final String NAMESPACE_URI = "http://www.hw4.com/groups";
    private final GroupService groupService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGroupByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetGroupByTitleResponse getGroupByTitle(@RequestPayload GetGroupByTitleRequest request) {
        GetGroupByTitleResponse response = new GetGroupByTitleResponse();
        response.setGroup(groupService.getByTitle(request.getTitle()));
        return response;
    }
}
