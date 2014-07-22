/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  Copyright 2013 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/
package com.adobe.cq.social.tally.client.impl;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.tally.Voting;
import com.adobe.cq.social.tally.client.api.AbstractVoting;

public class VotingSocialComponentImpl extends AbstractVoting {
    public VotingSocialComponentImpl(final Resource resource) {
        super(resource);
    }

    public VotingSocialComponentImpl(final Resource resource, final ClientUtilities clientUtils) {
        super(resource, clientUtils);
    }

    public VotingSocialComponentImpl(final Voting votingComponent, final ClientUtilities clientUtils) {
        super(votingComponent, clientUtils);
    }
}
