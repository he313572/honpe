
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
 *         &lt;element name="GetPuPriceItemTotalResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getPuPriceItemTotalResult"
})
@XmlRootElement(name = "GetPuPriceItemTotalResponse")
public class GetPuPriceItemTotalResponse {

    @XmlElement(name = "GetPuPriceItemTotalResult")
    protected String getPuPriceItemTotalResult;

    /**
     * Gets the value of the getPuPriceItemTotalResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetPuPriceItemTotalResult() {
        return getPuPriceItemTotalResult;
    }

    /**
     * Sets the value of the getPuPriceItemTotalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetPuPriceItemTotalResult(String value) {
        this.getPuPriceItemTotalResult = value;
    }

}
