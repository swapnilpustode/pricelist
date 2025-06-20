//package com.feeplan;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.ms.pricelist.entity.Feeplan;
//
//@SpringBootTest
////@DataJpaTest
//class FeeplanRepositoryTest {
//
//    @Autowired
//    private com.ms.pricelist.repository.feeplanRepository  feeplanRepository;
//
//    @Test
//    @DisplayName("Should find Feeplan by feeplanId")
//    void testFindByFeeplanId() {
//        // Arrange
//        Feeplan feeplan = new Feeplan();
//        feeplan.setFeeplanId("test-id-123");
//        feeplan.setFeeplanName("Test Plan");
//        feeplan.setCreatedDate(LocalDateTime.now());
//        feeplan.setUpdatedDate(LocalDateTime.now());
//        feeplan.setCreatedBy("Test User");
//        feeplan.setUpdatedBy("Test User");
//
//        // Save to DB
//        feeplanRepository.save(feeplan);
//
//        // Act
//        Optional<Feeplan> found = feeplanRepository.findByFeeplanId("test-id-123");
//
//        // Assert
//        assertThat(found).isPresent();
//        assertThat(found.get().getFeeplanName()).isEqualTo("Test Plan");
//    }
//}