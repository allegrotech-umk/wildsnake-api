package tech.allegro.wildsnake.unit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import tech.allegro.wildsnake.application.HomeController;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;
import tech.allegro.wildsnake.showcase.service.ShowcaseService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HomeControllerTests {

    @Mock
    private ShowcaseService showcaseService;
    @Mock
    private Model model;

    private List<ShowcaseItem> showcaseItems;

    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        homeController = new HomeController(showcaseService);
    }

    @Test
    public void shouldReturnHomePage() throws Exception {
        ReflectionTestUtils.setField(homeController, "pageMessage", "Under Constr");
        showcaseItems = Arrays.asList(new ShowcaseItem("title1", "http://localhost/image1", 55), new ShowcaseItem("title2", "http://localhost/image2", 66));
        when(showcaseService.getItems()).thenReturn(showcaseItems);

        assertEquals("index", homeController.mainPage(model));

        verify(model).addAttribute("pageMessage", "Under Constr");
        verify(model).addAttribute("showcaseItems", showcaseItems);
        verifyNoMoreInteractions(model);
    }

}
