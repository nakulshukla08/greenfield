//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 02:47:06 PM IST 
//


package com.greenfield.nexux_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nexusNGArtifact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nexusNGArtifact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latestReleaseRepositoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactHits" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="artifactHit" type="{}artifactHit" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="latestSnapshot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="highlightedFragment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latestSnapshotRepositoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latestRelease" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nexusNGArtifact", propOrder = {
    "groupId",
    "latestReleaseRepositoryId",
    "artifactHits",
    "latestSnapshot",
    "artifactId",
    "highlightedFragment",
    "latestSnapshotRepositoryId",
    "latestRelease",
    "version"
})
public class NexusNGArtifact {

    protected String groupId;
    protected String latestReleaseRepositoryId;
    protected NexusNGArtifact.ArtifactHits artifactHits;
    protected String latestSnapshot;
    protected String artifactId;
    protected String highlightedFragment;
    protected String latestSnapshotRepositoryId;
    protected String latestRelease;
    protected String version;

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the latestReleaseRepositoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatestReleaseRepositoryId() {
        return latestReleaseRepositoryId;
    }

    /**
     * Sets the value of the latestReleaseRepositoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatestReleaseRepositoryId(String value) {
        this.latestReleaseRepositoryId = value;
    }

    /**
     * Gets the value of the artifactHits property.
     * 
     * @return
     *     possible object is
     *     {@link NexusNGArtifact.ArtifactHits }
     *     
     */
    public NexusNGArtifact.ArtifactHits getArtifactHits() {
        return artifactHits;
    }

    /**
     * Sets the value of the artifactHits property.
     * 
     * @param value
     *     allowed object is
     *     {@link NexusNGArtifact.ArtifactHits }
     *     
     */
    public void setArtifactHits(NexusNGArtifact.ArtifactHits value) {
        this.artifactHits = value;
    }

    /**
     * Gets the value of the latestSnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatestSnapshot() {
        return latestSnapshot;
    }

    /**
     * Sets the value of the latestSnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatestSnapshot(String value) {
        this.latestSnapshot = value;
    }

    /**
     * Gets the value of the artifactId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * Sets the value of the artifactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtifactId(String value) {
        this.artifactId = value;
    }

    /**
     * Gets the value of the highlightedFragment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighlightedFragment() {
        return highlightedFragment;
    }

    /**
     * Sets the value of the highlightedFragment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighlightedFragment(String value) {
        this.highlightedFragment = value;
    }

    /**
     * Gets the value of the latestSnapshotRepositoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatestSnapshotRepositoryId() {
        return latestSnapshotRepositoryId;
    }

    /**
     * Sets the value of the latestSnapshotRepositoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatestSnapshotRepositoryId(String value) {
        this.latestSnapshotRepositoryId = value;
    }

    /**
     * Gets the value of the latestRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatestRelease() {
        return latestRelease;
    }

    /**
     * Sets the value of the latestRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatestRelease(String value) {
        this.latestRelease = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="artifactHit" type="{}artifactHit" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "artifactHit"
    })
    public static class ArtifactHits {

        protected List<ArtifactHit> artifactHit;

        /**
         * Gets the value of the artifactHit property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the artifactHit property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArtifactHit().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ArtifactHit }
         * 
         * 
         */
        public List<ArtifactHit> getArtifactHit() {
            if (artifactHit == null) {
                artifactHit = new ArrayList<ArtifactHit>();
            }
            return this.artifactHit;
        }

    }

}
