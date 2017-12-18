
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
 *         &lt;element name="EditPuPriceItemsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "editPuPriceItemsResult"
})
@XmlRootElement(name = "EditPuPriceItemsResponse")
public class EditPuPriceItemsResponse {

    @XmlElement(name = "EditPuPriceItemsResult")
    protected String editPuPriceItemsResult;

    /**
     * Gets the value of the editPuPriceItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditPuPriceItemsResult() {
        return editPuPriceItemsResult;
    }

    /**
     * Sets the value of the editPuPriceItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditPuPriceItemsResult(String value) {
        this.editPuPriceItemsResult = value;
    }

}
