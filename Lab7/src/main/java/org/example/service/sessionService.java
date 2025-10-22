package org.example.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class sessionService {
    @Autowired
    HttpSession session;


    /**
     * Đọc giá trị của attribute trong session
     * @param name tên attribute
     * @return giá trị đọc được hoặc null nếu không tồn tại
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        Object value = session.getAttribute(name);

        // Nếu không tìm thấy (value là null)
        if (value == null) {
            return defaultValue;
        }

        // Nếu tìm thấy, thử ép kiểu
        try {
            return (T) value;
        } catch (ClassCastException e) {
            // Nếu ép kiểu thất bại (ví dụ: lưu Integer nhưng lại get String)
            // thì trả về giá trị mặc định
            System.err.println("Lỗi ép kiểu session attribute: " + name);
            return defaultValue;
        }
    }


    /**
     * Thay đổi hoặc tạo mới attribute trong session
     * @param name tên attribute
     * @param value giá trị attribute
     */

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }
    /**
     * Xóa attribute trong session
     * @param name tên attribute cần xóa
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
