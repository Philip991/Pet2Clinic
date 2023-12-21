package org.springframework.samples.petclinic.fileUpload;


import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@GetMapping("/view")
	public String showUploadPage(){
		return "owners/uploadFile";
	}

	@PostMapping("/new")
	public String uploadFile(@RequestParam("file")MultipartFile file, Model model) throws IOException {

		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();

		try(InputStream inputStream = file.getInputStream();
			PDDocument document = PDDocument.load(inputStream)){

			PDFTextStripper textStripper = new PDFTextStripper();
			String pdfContent = textStripper.getText(document);

			log.info("Content===>>>{}",pdfContent);
			System.out.println("FileName: "+ fileName);
			System.out.println("FileSize: "+fileSize+"bytes");
			System.out.println("File Content:\n" + pdfContent);

			model.addAttribute("pdfContent", pdfContent);
		}


		return "owners/displayUploadedFile";
	}
}
