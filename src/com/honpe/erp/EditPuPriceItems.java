
package com.honpe.erp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="md5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queryInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "userid",
    "md5",
    "queryInfo"
})
@XmlRootElement(name = "EditPuPriceItems")
public class EditPuPriceItems {

    protected String userid;
    protected String md5;
    protected String queryInfo;

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the md5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMd5() {
        return md5;
    }

    /**
     * Sets the value of the md5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMd5(String value) {
        this.md5 = value;
    }

    /**
     * Gets the value of the queryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryInfo() {
        return queryInfo;
    }

    /**
     * Sets the value of the queryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryInfo(String value) {
        this.queryInfo = value;
    }

}
