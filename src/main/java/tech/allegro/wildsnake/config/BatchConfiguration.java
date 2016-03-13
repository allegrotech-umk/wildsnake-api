package tech.allegro.wildsnake.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import tech.allegro.wildsnake.batch.ProductItemProcessor;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<ProductDomain> reader() {
        FlatFileItemReader<ProductDomain> reader = new FlatFileItemReader<ProductDomain>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<ProductDomain>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"name", "imageUrl", "description", "price"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<ProductDomain>() {{
                setTargetType(ProductDomain.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ProductItemProcessor processor() {
        return new ProductItemProcessor();
    }

    @Bean
    public ItemWriter<Product> writer() {
        JpaItemWriter<Product> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(this.entityManagerFactory);
        return writer;
    }
    // end::readerwriterprocessor[]


    // tag::jobstep[]
    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importProductJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("importProductFromCSV")
                .<ProductDomain, Product>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    // end::jobstep[]
}
