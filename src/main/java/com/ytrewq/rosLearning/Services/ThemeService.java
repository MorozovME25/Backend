package com.ytrewq.rosLearning.Services;


import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.Repositories.Impl.ThemeRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ThemeService {
    @Autowired
    ThemeRepositoryImpl themeRepository;
    @Autowired
    CourseRepositoryImpl courseRepository;
    ModelMapper modelMapper = new ModelMapper();

    public Set<ThemesDto> getAllCourseThemes(int course_id) {
        Course course = courseRepository.findById(Course.class, course_id);
        if (course != null) {
            Set<Theme> themes = themeRepository.getAllCourseThemes(course_id);
            return themes.stream()
                    .map(theme -> modelMapper.map(theme, ThemesDto.class))
                    .collect(Collectors.toSet());
        } else throw new RuntimeException("Course not  found");

    }

    public Theme getThemeById(int theme_id) {
        return themeRepository.findById(Theme.class, theme_id);
    }

    public Set<ThemesDto> getAllThemes() {
        Set<Theme> themes = themeRepository.findAll(Theme.class);
        return themes.stream()
                .map(theme -> modelMapper.map(theme, ThemesDto.class))
                .collect(Collectors.toSet());
    }
}