
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
 *         &lt;element name="AddPuSuppliersItemResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addPuSuppliersItemResult"
})
@XmlRootElement(name = "AddPuSuppliersItemResponse")
public class AddPuSuppliersItemResponse {

    @XmlElement(name = "AddPuSuppliersItemResult")
    protected String addPuSuppliersItemResult;

    /**
     * Gets the value of the addPuSuppliersItemResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddPuSuppliersItemResult() {
        return addPuSuppliersItemResult;
    }

    /**
     * Sets the value of the addPuSuppliersItemResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddPuSuppliersItemResult(String value) {
        this.addPuSuppliersItemResult = value;
    }

}
