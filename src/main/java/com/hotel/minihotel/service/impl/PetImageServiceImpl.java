package com.informatique.gov.helpdesk.service.impl;

import static org.springframework.util.Assert.notNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.domain.PetImage;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.persistence.repository.PetImageRepository;
import com.informatique.gov.helpdesk.persistence.repository.PetRepository;
import com.informatique.gov.helpdesk.rest.dto.PetImageDto;
import com.informatique.gov.helpdesk.service.PetImageService;
import com.informatique.gov.helpdesk.support.modelmapper.PetImageMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PetImageServiceImpl implements PetImageService {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetImageRepository petImageRepository;
	private PetImageMapper petMapper;
	private PetRepository petRepository;

	@Override
	public List<PetImage> getAllByPetId(Integer petId) throws ShowDogException {
		List<PetImage> petImages = null;
		try {
			petImages = petImageRepository.findAllByPetId(petId);
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return petImages;
	}

	@Override
	public PetImageDto addPetImage(Integer petId, MultipartFile image) throws ShowDogException {
		PetImageDto savedDto = null;
		try {
			notNull(petId, "petId must be set");

			Pet pet = petRepository.findById(petId).get();

			PetImage entity = new PetImage();
			// petMapper.toNewEntity(petImageDto);
			entity.setPet(pet);
			entity.setProfileImage(false);
			Cloudinary cloudinary = new Cloudinary(
					ObjectUtils.asMap("sdimagemanagment", "sdimagemanagment", "444577351626788", "444577351626788",
							"DOPYfxEzaQ6lRdVWVVYwTqFMUPo", "DOPYfxEzaQ6lRdVWVVYwTqFMUPo"));
			cloudinary.config.apiKey = "444577351626788";
			cloudinary.config.apiSecret = "DOPYfxEzaQ6lRdVWVVYwTqFMUPo";
			cloudinary.config.cloudName = "sdimagemanagment";
		//	File newFile = new File("C:\\Users\\mohhossam\\Desktop\\x.png");
			//image.transferTo(newFile);
		//	File toUpload = newFile;
			Map uploadResult = null;
			try {
				uploadResult = cloudinary.uploader().upload(image.getBytes(),
						ObjectUtils.asMap("sdimagemanagment", "sdimagemanagment", "444577351626788", "444577351626788",
								"DOPYfxEzaQ6lRdVWVVYwTqFMUPo", "DOPYfxEzaQ6lRdVWVVYwTqFMUPo"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entity.setImage((String) uploadResult.get("url"));
			entity = petImageRepository.save(entity);

			savedDto = petMapper.toDto(entity);

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return savedDto;
	}

}