package com.example.gcprofile;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userdata")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataRepository repository;

    @PostMapping("/fill")
    public String fillDatabase(@RequestParam(defaultValue = "1000") int count) {
        List<UserData> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(UserData.builder()
                    .name("User" + i)
                    .email("user" + i + "@example.com")
                    .phone("+123456789" + i)
                    .address("Some street, Building " + i)
                    .comment("Some comment here")
                    .metadata("Some large metadata blob: " + "X".repeat(1000))
                    .build());
        }
        repository.saveAll(list);
        return "Inserted " + count + " records";
    }

    @GetMapping("/all")
    public List<UserData> getAll() {
        return repository.findAll();
    }
}
