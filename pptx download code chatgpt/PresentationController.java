import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/presentation")
public class PresentationController {
  @GetMapping
  public ResponseEntity<InputStreamResource> getPresentation() throws IOException {
    // Create a new PowerPoint presentation
    XMLSlideShow presentation = new XMLSlideShow();

    // Create a slide
    XSLFSlide slide = presentation.createSlide();

    // Add a title to the slide
    XSLFTextBox title = slide.createTextBox();
    title.setText("Hello, World!");

    // Save the presentation to a byte array
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    presentation.write(outputStream);
    byte[] bytes = outputStream.toByteArray();

    // Set the content type and attachment header
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=hello_world.pptx");

    // Create the response entity with the byte array as the body and the headers
    return ResponseEntity
      .ok()
      .headers(headers)
      .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.presentationml.presentation"))
      .body(new InputStreamResource(new ByteArrayInputStream(bytes)));
  }
}

