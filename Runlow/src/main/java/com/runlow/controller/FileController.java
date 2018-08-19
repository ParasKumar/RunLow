package com.runlow.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.runlow.constants.CommonConstants;
import com.runlow.model.Driver;
import com.runlow.payload.UploadFileResponse;
import com.runlow.repository.DriverRepository;
import com.runlow.repository.UserRepository;
import com.runlow.service.FileStorageService;

@RestController
@RequestMapping("/driver/file/")
public class FileController {
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${file.upload-dir}")
	private String fileUploadPath;
	
	/**
	 * This method uploads national id front part
	 * */
	@PostMapping("/upload/nationalIdFront/{userId}")
    public UploadFileResponse uploadNationalIdFront(@RequestParam("nationalIdFront") MultipartFile file, @PathVariable("userId") Integer userId) {
		String fileName = fileStorageService.storeFile(file, userId + "_national_id_front");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(CommonConstants.DRIVER_FILE_DOWNLOAD_URL)
                .path(fileName)
                .toUriString();
        
        // save the path of file to db
        Driver driver = driverRepository.findDriverByUserId(userId);
        if (driver == null) {
        	driver = new Driver();
        	driver.setUser(userRepository.getOne(userId));
        }
    	driver.setNationalIdFront(fileName);
        driverRepository.save(driver);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	
	/**
	 * This method uploads national id back part
	 * */
	@PostMapping("/upload/nationalIdBack/{userId}")
    public UploadFileResponse uploadNationalIdBack(@RequestParam("nationalIdBack") MultipartFile file, @PathVariable("userId") Integer userId) {
		//String customFileName = userId + "_national_id_back";
		String fileName = fileStorageService.storeFile(file, userId + "_national_id_back");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(CommonConstants.DRIVER_FILE_DOWNLOAD_URL)
                .path(fileName)
                .toUriString();
        
        // save the path of file to db
        Driver driver = driverRepository.findDriverByUserId(userId);
        if (driver == null) {
        	driver = new Driver();
        	driver.setUser(userRepository.getOne(userId));
        }
    	driver.setNationalIdBack(fileName);
        driverRepository.save(driver);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
//	
//	/**
//	 * This method uploads driving license front part
//	 * */
//	@PostMapping("/upload/drivingLicenseFront")
//    public UploadFileResponse uploadDrivingLicenseFront(@RequestParam("drivingLicenseFront") MultipartFile file,  @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//     // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setDrivingLecenseFront(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads driving license back part
//	 * */
//	@PostMapping("/upload/drivingLicenseBack")
//    public UploadFileResponse uploadDrivingLicenseBack(@RequestParam("drivingLicenseBack") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//     // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setDrivingLicenseBack(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads driver photo
//	 * */
//	@PostMapping("/upload/driverPhoto")
//    public UploadFileResponse uploadDriverPhoto(@RequestParam("driverPhoto") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setDriverPhoto(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads billing proof
//	 * */
//	@PostMapping("/upload/billingProof")
//    public UploadFileResponse uploadBillingProof(@RequestParam("billingProof") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setBillingProof(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads no objection letter
//	 * */
//	@PostMapping("/upload/noObjectionLetter")
//    public UploadFileResponse uploadNoObjectionLetter(@RequestParam("noObjectionLetter") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setNoObjectionLetter(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads vehicle image
//	 * */
//	@PostMapping("/upload/vehicleImage")
//    public UploadFileResponse uploadVehicleImage(@RequestParam("vehicleImage") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setVehicleImage(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads vehicle registration certificate
//	 * */
//	@PostMapping("/upload/vehicleRegistrationCertificate")
//    public UploadFileResponse uploadVehicleRegistrationCertificate(@RequestParam("vehicleRegistrationCertificate") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setVehicleRegistrationCertificate(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads revenue license
//	 * */
//	@PostMapping("/upload/revenueLicense")
//    public UploadFileResponse uploadRevenueLicense(@RequestParam("revenueLicense") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setRevenueLicense(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	/**
//	 * This method uploads vehicle insurance certificate
//	 * */
//	@PostMapping("/upload/insuranceCertificate")
//    public UploadFileResponse uploadInsuranceCertificate(@RequestParam("insuranceCertificate") MultipartFile file, @PathVariable("userId") Integer userId) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//        
//        // save the path of file to db
//        Driver driver = driverRepository.findDriverByUserId(userId);
//        if (driver == null) {
//        	driver = new Driver();
//        	driver.setUser(userRepository.getOne(userId));
//        }
//    	driver.setInsuranceCertificate(fileName);
//        driverRepository.save(driver);
//        
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//	
//	@PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadDrivingLicenseBack(file,1))
//                .collect(Collectors.toList());
//    }
//	
	@GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        System.out.println("file Name : " + fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
//	
//	/**
//	 * This method delete file
//	 * @param fileName name of file to be deleted from server/local path
//	 * */
//	@PostMapping("/delete/{fileName}")
//    public ResponseEntity<Map<String,String>> deleteDriverDocument(@PathVariable("fileName") String fileName) {
//		System.out.println("path is " + fileUploadPath);
//    	//String fileDirectory = fileUploadPath + fileName;//CommonConstants.FILE_DIRECTORY + fileName;
//    	Path targetLocation = Paths.get(fileUploadPath)
//						           	.toAbsolutePath()
//						           	.normalize()
//						           	.resolve(fileName);
//    	
//    	ResponseEntity<Map<String,String>> returnVal = null;
//    	Map<String,String> resultMap = new HashMap<>();
//    	try {
//	    	//File file = new File(fileDirectory);
//    		// file.delete()
//	    	Files.delete(targetLocation);
//	    	System.out.println(targetLocation.getFileName() + " is deleted!");
//    		resultMap.put(CommonConstants.VAL_RESULT, CommonConstants.VAL_SUCCESS);
//    		resultMap.put(CommonConstants.VAL_MESSAGE,"Successfully deleted file with name "+ fileName);
//    		returnVal =  new ResponseEntity<Map<String, String>>(resultMap,HttpStatus.OK);
//	    	
//    	} catch (Exception e) {
//    		resultMap.put(CommonConstants.VAL_RESULT, CommonConstants.VAL_FAILED);
//    		resultMap.put(CommonConstants.VAL_MESSAGE,e.getClass().getCanonicalName());
//    		e.printStackTrace();
//    		returnVal =  new ResponseEntity<Map<String, String>>(resultMap,HttpStatus.NOT_FOUND);
//    	}
//        return returnVal;
//    }
}
