
package dogood.hackathon.navi.sample.domain.repository;

import dogood.hackathon.navi.sample.domain.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {

}
