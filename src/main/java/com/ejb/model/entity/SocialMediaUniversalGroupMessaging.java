/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "social_media_universal_group_messaging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUniversalGroupMessaging.findAll", query = "SELECT s FROM SocialMediaUniversalGroupMessaging s")
    , @NamedQuery(name = "SocialMediaUniversalGroupMessaging.findById", query = "SELECT s FROM SocialMediaUniversalGroupMessaging s WHERE s.id = :id")})
public class SocialMediaUniversalGroupMessaging implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "social_media_universal_messaging_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUniversalMessaging socialMediaUniversalMessagingId;
    @JoinColumn(name = "social_media_user_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroup socialMediaUserGroupId;

    public SocialMediaUniversalGroupMessaging() {
    }

    public SocialMediaUniversalGroupMessaging(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SocialMediaUniversalMessaging getSocialMediaUniversalMessagingId() {
        return socialMediaUniversalMessagingId;
    }

    public void setSocialMediaUniversalMessagingId(SocialMediaUniversalMessaging socialMediaUniversalMessagingId) {
        this.socialMediaUniversalMessagingId = socialMediaUniversalMessagingId;
    }

    public SocialMediaGroup getSocialMediaUserGroupId() {
        return socialMediaUserGroupId;
    }

    public void setSocialMediaUserGroupId(SocialMediaGroup socialMediaUserGroupId) {
        this.socialMediaUserGroupId = socialMediaUserGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialMediaUniversalGroupMessaging)) {
            return false;
        }
        SocialMediaUniversalGroupMessaging other = (SocialMediaUniversalGroupMessaging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUniversalGroupMessaging[ id=" + id + " ]";
    }
    
}
