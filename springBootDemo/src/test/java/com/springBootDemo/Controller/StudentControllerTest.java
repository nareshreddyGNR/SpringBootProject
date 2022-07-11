package com.springBootDemo.Controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.springBootDemo.Exceptions.InputsDataErrors;
import com.springBootDemo.Exceptions.ResourceNotFoundException;
import com.springBootDemo.Model.Address;
import com.springBootDemo.Model.StudentDetails;
import com.springBootDemo.Service.StudentService;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentController#getAllStudents(String)}
     */
    @Test
    void testGetAllStudents() throws Exception {
        when(this.studentService.deleteByNumber((String) any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/student/{studentNumber}", "42");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudents(String)}
     */
    @Test
    void testGetAllStudents2() throws Exception {
        when(this.studentService.deleteByNumber((String) any())).thenReturn("42");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/student/{studentNumber}", "42");
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudents(String)}
     */
    @Test
    void testGetAllStudents3() throws Exception {
        when(this.studentService.deleteByNumber((String) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/student/{studentNumber}", "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link StudentController#getAllStudentsRecordsByLocation(String)}
     */
    @Test
    void testGetAllStudentsRecordsByLocation() throws Exception {
        when(this.studentService.getAllREcordsWithLoction((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/byCity/{cityName}", "Oxford");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudentsRecordsByLocation(String)}
     */
    @Test
    void testGetAllStudentsRecordsByLocation2() throws Exception {
        when(this.studentService.getAllREcordsWithLoction((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/student/byCity/{cityName}", "Oxford");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#SaveStudentData(StudentDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveStudentData() throws InputsDataErrors {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint 'javax.validation.constraints.Pattern' validating type 'java.lang.Long'. Check configuration for 'age'
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getExceptionForNullValidator(ConstraintTree.java:116)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getInitializedConstraintValidator(ConstraintTree.java:162)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.SimpleConstraintTree.validateConstraints(SimpleConstraintTree.java:54)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.validateConstraints(ConstraintTree.java:75)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.doValidateConstraint(MetaConstraint.java:130)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.validateConstraint(MetaConstraint.java:123)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateMetaConstraint(ValidatorImpl.java:555)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForSingleDefaultGroupElement(ValidatorImpl.java:518)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForDefaultGroup(ValidatorImpl.java:488)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForCurrentGroup(ValidatorImpl.java:450)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateInContext(ValidatorImpl.java:400)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validate(ValidatorImpl.java:172)
        //       at org.springframework.validation.beanvalidation.SpringValidatorAdapter.validate(SpringValidatorAdapter.java:109)
        //       at org.springframework.validation.DataBinder.validate(DataBinder.java:900)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.validateIfApplicable(AbstractMessageConverterMethodArgumentResolver.java:245)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:139)
        //       at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:179)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:146)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent SaveStudentData(StudentDetails)
        //   from throwing UnexpectedTypeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   SaveStudentData(StudentDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.springBootDemo.Controller.StudentController.SaveStudentData(StudentController.java:26)
        //   In order to prevent SaveStudentData(StudentDetails)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   SaveStudentData(StudentDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController();

        Address address = new Address();
        address.setCity("Oxford");
        address.setFlatNumber(10);
        address.setPinCode(1);
        address.setStreetName("Street Name");

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setAge(1L);
        studentDetails.setId(ObjectId.get());
        studentDetails.setStandard(1);
        studentDetails.setStudentAddress(address);
        studentDetails.setStudentName("Student Name");
        studentDetails.setStudentNumber("42");
        studentController.SaveStudentData(studentDetails);
    }

    /**
     * Method under test: {@link StudentController#SaveStudentData(StudentDetails)}
     */
    @Test
    void testSaveStudentData2() throws InputsDataErrors {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint 'javax.validation.constraints.Pattern' validating type 'java.lang.Long'. Check configuration for 'age'
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getExceptionForNullValidator(ConstraintTree.java:116)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getInitializedConstraintValidator(ConstraintTree.java:162)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.SimpleConstraintTree.validateConstraints(SimpleConstraintTree.java:54)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.validateConstraints(ConstraintTree.java:75)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.doValidateConstraint(MetaConstraint.java:130)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.validateConstraint(MetaConstraint.java:123)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateMetaConstraint(ValidatorImpl.java:555)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForSingleDefaultGroupElement(ValidatorImpl.java:518)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForDefaultGroup(ValidatorImpl.java:488)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForCurrentGroup(ValidatorImpl.java:450)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateInContext(ValidatorImpl.java:400)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validate(ValidatorImpl.java:172)
        //       at org.springframework.validation.beanvalidation.SpringValidatorAdapter.validate(SpringValidatorAdapter.java:109)
        //       at org.springframework.validation.DataBinder.validate(DataBinder.java:900)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.validateIfApplicable(AbstractMessageConverterMethodArgumentResolver.java:245)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:139)
        //       at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:179)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:146)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent SaveStudentData(StudentDetails)
        //   from throwing UnexpectedTypeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   SaveStudentData(StudentDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        assertThrows(InputsDataErrors.class, () -> (new StudentController()).SaveStudentData(null));
    }

    /**
     * Method under test: {@link StudentController#SaveStudentData(StudentDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveStudentData3() throws InputsDataErrors {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint 'javax.validation.constraints.Pattern' validating type 'java.lang.Long'. Check configuration for 'age'
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getExceptionForNullValidator(ConstraintTree.java:116)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.getInitializedConstraintValidator(ConstraintTree.java:162)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.SimpleConstraintTree.validateConstraints(SimpleConstraintTree.java:54)
        //       at org.hibernate.validator.internal.engine.constraintvalidation.ConstraintTree.validateConstraints(ConstraintTree.java:75)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.doValidateConstraint(MetaConstraint.java:130)
        //       at org.hibernate.validator.internal.metadata.core.MetaConstraint.validateConstraint(MetaConstraint.java:123)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateMetaConstraint(ValidatorImpl.java:555)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForSingleDefaultGroupElement(ValidatorImpl.java:518)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForDefaultGroup(ValidatorImpl.java:488)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateConstraintsForCurrentGroup(ValidatorImpl.java:450)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validateInContext(ValidatorImpl.java:400)
        //       at org.hibernate.validator.internal.engine.ValidatorImpl.validate(ValidatorImpl.java:172)
        //       at org.springframework.validation.beanvalidation.SpringValidatorAdapter.validate(SpringValidatorAdapter.java:109)
        //       at org.springframework.validation.DataBinder.validate(DataBinder.java:900)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.validateIfApplicable(AbstractMessageConverterMethodArgumentResolver.java:245)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:139)
        //       at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:179)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:146)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent SaveStudentData(StudentDetails)
        //   from throwing UnexpectedTypeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   SaveStudentData(StudentDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.springBootDemo.Controller.StudentController.SaveStudentData(StudentController.java:26)
        //   In order to prevent SaveStudentData(StudentDetails)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   SaveStudentData(StudentDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController();

        Address address = new Address();
        address.setCity("Oxford");
        address.setFlatNumber(10);
        address.setPinCode(1);
        address.setStreetName("Street Name");
        StudentDetails studentDetails = mock(StudentDetails.class);
        doNothing().when(studentDetails).setAge(anyLong());
        doNothing().when(studentDetails).setStandard(anyInt());
        doNothing().when(studentDetails).setStudentAddress((Address) any());
        doNothing().when(studentDetails).setStudentName((String) any());
        doNothing().when(studentDetails).setStudentNumber((String) any());
        doNothing().when(studentDetails).setId((ObjectId) any());
        studentDetails.setAge(1L);
        studentDetails.setId(ObjectId.get());
        studentDetails.setStandard(1);
        studentDetails.setStudentAddress(address);
        studentDetails.setStudentName("Student Name");
        studentDetails.setStudentNumber("42");
        studentController.SaveStudentData(studentDetails);
    }

    /**
     * Method under test: {@link StudentController#getStudentDataByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetStudentDataByName() throws ResourceNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.springBootDemo.Controller.StudentController.getStudentDataByName(StudentController.java:37)
        //   In order to prevent getStudentDataByName(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getStudentDataByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StudentController()).getStudentDataByName("Name");
    }

    /**
     * Method under test: {@link StudentController#getStudentDataByNumber(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetStudentDataByNumber() throws ResourceNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.springBootDemo.Controller.StudentController.getStudentDataByNumber(StudentController.java:42)
        //   In order to prevent getStudentDataByNumber(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getStudentDataByNumber(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StudentController()).getStudentDataByNumber("42");
    }

    /**
     * Method under test: {@link StudentController#getAllStudentsRecords()}
     */
    @Test
    void testGetAllStudentsRecords() throws Exception {
        when(this.studentService.getAllStudents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/getAllStudentsData");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudentsRecords()}
     */
    @Test
    void testGetAllStudentsRecords2() throws Exception {
        when(this.studentService.getAllStudents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/student/getAllStudentsData");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#updateStudentRecord(String, String)}
     */
    @Test
    void testUpdateStudentRecord() throws Exception {
        when(this.studentService.updateStudentDetails((String) any(), (String) any())).thenReturn("2020-03-01");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/student/updateStudent/{studentNumber}/{studentName}", "42", "Student Name");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

    /**
     * Method under test: {@link StudentController#updateStudentRecord(String, String)}
     */
    @Test
    void testUpdateStudentRecord2() throws Exception {
        when(this.studentService.updateStudentDetails((String) any(), (String) any())).thenReturn("2020-03-01");
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders
                .put("/student/updateStudent/{studentNumber}/{studentName}", "42", "Student Name");
        putResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(putResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }
}

