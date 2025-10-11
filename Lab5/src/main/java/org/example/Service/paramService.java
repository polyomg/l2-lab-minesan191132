package org.example.Service;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;


@Service
public class paramService {

    @Autowired
    HttpServletRequest request;

    /**
     * Đọc chuỗi giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */

    public String getString(String name, String defaultValue) {
        return Optional.ofNullable(request.getParameter(name)).map(String::trim).filter(Value -> !Value.isBlank()).orElse(defaultValue);
    }

    /**
     * Đọc số nguyên giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */


    private Optional<Integer> tryParseInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s.trim()));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int getInt(String name, int defaultValue) {
        return Optional.ofNullable(request.getParameter(name)).flatMap(value -> tryParseInt(value)).orElse(defaultValue);
    }


    /**
     * Đọc số thực giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */

    private Optional<Double> tryParseDouble(String s) {
        try {
            return Optional.of(Double.parseDouble(s.trim()));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public double getDouble(String name, double defaultValue) {
        return Optional.ofNullable(request.getParameter(name)).flatMap(value -> tryParseDouble(value)).orElse(defaultValue);
    }


    /**
     * Đọc giá trị boolean của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */

    public boolean getBoolean(String name, boolean defaultValue) {
        return Optional.ofNullable(request.getParameter(name)).filter(value -> !value.isBlank()).map(Boolean::parseBoolean).orElse(defaultValue);
    }

    /**
     * Đọc giá trị thời gian của tham số
     *
     * @param name    tên tham số
     * @param pattern là định dạng thời gian
     * @return giá trị tham số hoặc null nếu không tồn tại
     * @throws RuntimeException lỗi sai định dạng
     */

    private Optional<LocalDate> tryParseDate(String dates, DateTimeFormatter formatter) {
        try {
            return Optional.of(LocalDate.parse(dates, formatter));
        } catch (DateTimeParseException d) {
            return Optional.empty();
        }
    }

    public LocalDate getDate(String name, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        return Optional.ofNullable(request.getParameter(name)).filter(value -> !value.isBlank())
                .flatMap(value -> tryParseDate(value, formatter)).orElse(null);
    }

    /**
     * Lưu file upload vào thư mục
     *
     * @param file chứa file upload từ client
     * @param path đường dẫn tính từ webroot
     * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
     * @throws RuntimeException lỗi lưu file
     */
    public static final String directory = "D:/File/";

    public Optional<File> save(MultipartFile file, String path) {
        return Optional.ofNullable(file)
                .filter(f -> !f.isEmpty())
                //lấy tên của file
                .map(MultipartFile::getOriginalFilename)
                //làm sạch đường dẫn của file ../../t.txt -> "t.txt"
                .map(StringUtils::cleanPath)
                .flatMap(filename -> {
                    try {
                        //tạo đối tượng file đích
                        File newfile = new File(directory + filename);

                        //lưu file
                        file.transferTo(newfile);

                        return Optional.of(newfile);
                    } catch (IOException e) {
                        return Optional.empty();
                    }
                });
    }
}

