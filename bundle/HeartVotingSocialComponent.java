package com.adobe.cq.social.custom.voting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.User;
import com.adobe.cq.social.tally.Response;
import com.adobe.cq.social.tally.ResponseValue;
import com.adobe.cq.social.tally.Tally;
import com.adobe.cq.social.tally.Vote;
import com.adobe.cq.social.tally.Voting;
import com.adobe.cq.social.tally.client.api.AbstractVoting;


public class HeartVotingSocialComponent extends AbstractVoting{
    public HeartVotingSocialComponent(final Resource resource) {
        super(resource);
    }

    public HeartVotingSocialComponent(final Resource resource, final ClientUtilities clientUtils) {
        super(resource, clientUtils);
    }

    public HeartVotingSocialComponent(final Voting votingComponent, final ClientUtilities clientUtils) {
        super(votingComponent, clientUtils);
    }
    
    public List<User> getLikedBy() {
        List<User> users = new ArrayList<User>();
        Tally<?> tallies = this.getTally();
        Iterator<?> responses = tallies.getResponses(0L);
        while (responses.hasNext()) {
            Response<ResponseValue> r = (Response<ResponseValue>) responses.next();
            if (Vote.LIKE.equals(r.getResponseValue())) {
                users.add(clientUtils.getUser(r.getUserId(), this.getResource().getResourceResolver()));
            }
        }
        return users;
    }
}