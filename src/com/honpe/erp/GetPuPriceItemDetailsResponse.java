
package com.honpe.erp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetPuPriceItemDetailsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getPuPriceItemDetailsResult"
})
@XmlRootElement(name = "GetPuPriceItemDetailsResponse")
public class GetPuPriceItemDetailsResponse {

    @XmlElement(name = "GetPuPriceItemDetailsResult")
    protected String getPuPriceItemDetailsResult;

    /**
     * Gets the value of the getPuPriceItemDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetPuPriceItemDetailsResult() {
        return getPuPriceItemDetailsResult;
    }

    /**
     * Sets the value of the getPuPriceItemDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetPuPriceItemDetailsResult(String value) {
        this.getPuPriceItemDetailsResult = value;
    }

}
