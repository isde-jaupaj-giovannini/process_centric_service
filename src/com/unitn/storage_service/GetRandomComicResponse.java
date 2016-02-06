
package com.unitn.storage_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRandomComicResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRandomComicResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://storage_service.unitn.com/}xkcdComic" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRandomComicResponse", propOrder = {
    "_return"
})
public class GetRandomComicResponse {

    @XmlElement(name = "return")
    protected XkcdComic _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link XkcdComic }
     *     
     */
    public XkcdComic getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link XkcdComic }
     *     
     */
    public void setReturn(XkcdComic value) {
        this._return = value;
    }

}
