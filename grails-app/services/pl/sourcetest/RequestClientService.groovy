package pl.sourcetest

import wslite.soap.*


class RequestClientService {


    //TODO urls should be parameterized

    def getCoordinatesByZipCode(zipcode) {
        def client = new SOAPClient('https://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php')
        def response = client.send(SOAPAction:'https://graphical.weather.gov/xml/DWMLgen/wsdl/ndfdXML.wsdl') {
            body {
                LatLonListZipCode('xmlns':'https://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd') {
                    zipCodeList(zipcode)
                }
            }
        }
        def theValue = response.LatLonListZipCodeResponse
        new XmlSlurper().parseText(theValue.text())
    }

    def getCoordinatesBySectorCode(typedSector) {
        def client = new SOAPClient('https://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php')
        def response = client.send(SOAPAction:'https://graphical.weather.gov/xml/DWMLgen/wsdl/ndfdXML.wsdl') {
            body {
                CornerPoints('xmlns':'https://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd') {
                    sector(typedSector)
                }
            }
        }
        def theValue = response.CornerPointsResponse
        new XmlSlurper().parseText(theValue.text())

    }

}
