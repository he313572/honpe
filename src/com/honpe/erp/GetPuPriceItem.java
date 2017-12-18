
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
 *         &lt;element name="querycondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pagesize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentpage" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "querycondition",
    "pagesize",
    "currentpage"
})
@XmlRootElement(name = "GetPuPriceItem")
public class GetPuPriceItem {

    protected String userid;
    protected String md5;
    protected String querycondition;
    protected int pagesize;
    protected int currentpage;

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
     * Gets the value of the querycondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuerycondition() {
        return querycondition;
    }

    /**
     * Sets the value of the querycondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuerycondition(String value) {
        this.querycondition = value;
    }

    /**
     * Gets the value of the pagesize property.
     * 
     */
    public int getPagesize() {
        return pagesize;
    }

    /**
     * Sets the value of the pagesize property.
     * 
     */
    public void setPagesize(int value) {
        this.pagesize = value;
    }

    /**
     * Gets the value of the currentpage property.
     * 
     */
    public int getCurrentpage() {
        return currentpage;
    }

    /**
     * Sets the value of the currentpage property.
     * 
     */
    public void setCurrentpage(int value) {
        this.currentpage = value;
    }

}
