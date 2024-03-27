package com.audax.AudaxTimeSheet.services;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.audax.AudaxTimeSheet.entities.Resource;
import com.audax.AudaxTimeSheet.helper.ResourceHelper;
import com.audax.AudaxTimeSheet.repositories.ResourceRepo;

@Service
public class ResourceService {
	 @Autowired
	    private ResourceRepo resourceRepo;

	    public void save(MultipartFile file) {

	        try {
	            List<Resource> products = ResourceHelper.convertExcelToListOfResource(file.getInputStream());
	            this.resourceRepo.saveAll(products);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    public List<Resource> getAllProducts() {
	        return this.resourceRepo.findAll();
	    }
}
