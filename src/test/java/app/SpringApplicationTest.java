package app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@SpringBootTest
@AutoConfigureMockMvc
class MySpringApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/new")).andExpect(status().isOk());
        this.mockMvc.perform(get("/addressBook").param("id", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook")));
    }

    @Test
    public void addAndRemoveBuddy() throws Exception {
        this.mockMvc.perform(post("/new")).andExpect(status().isOk());
        this.mockMvc.perform(get("/addressBook").param("id", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook")));

        this.mockMvc.perform(post("/addBuddy")
                .param("bookId", "1")
                .param("name", "buddyname2")
                .param("phone", "613")).andExpect(status().isOk());

        this.mockMvc.perform(post("/addBuddy")
                .param("bookId", "1")
                .param("name", "buddyname3")
                .param("phone", "613")).andExpect(status().isOk());

        this.mockMvc.perform(get("/addressBook")
                .param("id", "1"))
                .andExpect(content().string(containsString("buddyname2")))
                .andExpect(content().string(containsString("buddyname3")));

        this.mockMvc.perform(post("/removeBuddy").param("id", "2")).andExpect(status().isOk());

        this.mockMvc.perform(get("/addressBook").param("id", "1"))
                .andExpect(content().string(not(containsString("buddyname2"))))
                .andExpect(content().string(containsString("buddyname3")));

    }
}