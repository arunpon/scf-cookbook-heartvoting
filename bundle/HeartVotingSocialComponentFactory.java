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
package com.adobe.cq.social.custom.voting;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.commons.client.api.AbstractSocialComponentFactory;
import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.SocialComponent;
import com.adobe.cq.social.commons.client.api.SocialComponentFactory;
import com.adobe.cq.social.tally.Voting;
import com.adobe.granite.xss.XSSAPI;

/**
 * Default SocialComponentFactory for Heart Voting.
 */
@Component
@Service
public class HeartVotingSocialComponentFactory extends AbstractSocialComponentFactory implements SocialComponentFactory {

    private static final String VOTING_RESOURCE_TYPE = "community-components/components/social/voting/components/hbs/voting";

    @Reference
    private XSSAPI xss;

    @Override
    public SocialComponent getSocialComponent(final Resource resource) {
        return new HeartVotingSocialComponent(resource.adaptTo(Voting.class), this.getClientUtilities(resource
            .getResourceResolver()));
    }

    @Override
    public SocialComponent getSocialComponent(final Resource resource, final SlingHttpServletRequest request) {
        return new HeartVotingSocialComponent(resource.adaptTo(Voting.class), this.getClientUtilities(request));
    }

    @Override
    public String getSupportedResourceType() {
        return VOTING_RESOURCE_TYPE;
    }

    @Override
    public SocialComponent getSocialComponent(final Resource resource, final ClientUtilities clientUtils,
        final QueryRequestInfo queryInfo) {
        return new HeartVotingSocialComponent(resource, clientUtils);
    }
}
