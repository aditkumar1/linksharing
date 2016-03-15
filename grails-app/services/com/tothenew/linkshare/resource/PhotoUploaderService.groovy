package com.tothenew.linkshare.resource

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class PhotoUploaderService {
 def grailsApplication
    def uploadPicture(MultipartFile photo) {
        MultipartFile inputImage = photo
        return inputImage.bytes
    }
}
