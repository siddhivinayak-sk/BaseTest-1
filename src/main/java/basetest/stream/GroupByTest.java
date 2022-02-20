package basetest.stream;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class GroupByTest {

	List<BlogPost> data;
	
	public static void main(String...args) {
		GroupByTest test = new GroupByTest();
		test.prepareData1();
		test.grpTest1();
	}
	
	void grpTest1() {
		/**
		 * Group by single column
		 */
		Map<BlogPostType, List<BlogPost>> blogPostsByType = data.stream().collect(Collectors.groupingBy(BlogPost::getType));
		
		
		/**
		 * Group by multiple columns - two or more columns
		 */
		Map<Pair<BlogPostType, String>, List<BlogPost>> blogPostsByTypeAndAuthor = data.stream().collect(Collectors.groupingBy(post -> {
			return new ImmutablePair<>(post.getType(), post.getAuthor());
		}));
		
		Map<Tuple, List<BlogPost>> blogPostByTuple = data.stream().collect(Collectors.groupingBy(post -> {
			return new Tuple(post.getAuthor(), post.getType());
		}));
		
		

		/**
		 * Group by and then group by on result on another column
		 */
		Map<String, Map<BlogPostType, List<BlogPost>>> blogPostByAuthorAndByType = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));

		
		/**
		 * Group by and average
		 */
		Map<String, Double> averageLikesByAuthor = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.averagingInt(BlogPost::getLikes)));
		
		
		/**
		 * Group by and sum
		 */
		Map<String, Integer> sumLikesByAuthor = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.summingInt(BlogPost::getLikes)));
		
		
		/**
		 * Group by and min & max
		 */
		Map<String, Optional<BlogPost>> minLikesByAuthor = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.minBy(Comparator.comparingInt(BlogPost::getLikes))));
		Map<String, Optional<BlogPost>> maxLikesByAuthor = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));
		
		/**
		 * Group by and summary e.g. count, sum, average, min, max
		 */
		Map<BlogPostType, IntSummaryStatistics> summaryLikesByType = data.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summarizingInt(BlogPost::getLikes)));
		
		
		/**
		 * Group by and aggregation of multiple columns
		 */
		Map<String, PostCountTitlesLikesStats> authorByPostCountTitlesLikesStats = data.stream().collect(Collectors.groupingBy(BlogPost::getAuthor,
				Collectors.collectingAndThen(Collectors.toList(), list -> {
					long count = list.stream().map(BlogPost::getTitle).collect(Collectors.counting());
					String titles = list.stream().map(BlogPost::getTitle).collect(Collectors.joining(","));
					IntSummaryStatistics stat = list.stream().collect(Collectors.summarizingInt(BlogPost::getLikes));
					return new PostCountTitlesLikesStats(count, titles, stat);
				})));
		
		
		/**
		 * Group by author and concatanate column with bounded sum based upon given number
		 */
		int maxValLikes = 10;
		Map<String, TitlesBoundedSumOfLikes> postsPerAuthor = data.stream()
				.collect(
				Collectors.toMap(
						BlogPost::getAuthor, post -> {
					int likes = (post.getLikes() > maxValLikes) ? maxValLikes : post.getLikes();
					return new TitlesBoundedSumOfLikes(post.getTitle(), likes);
				}, 
				(u1, u2) -> {
					int likes = (u2.getBoundedSumOfLikes() > maxValLikes) ? maxValLikes : u2.getBoundedSumOfLikes();
					return new TitlesBoundedSumOfLikes(u1.getTitles().toUpperCase() + " : " + u2.getTitles().toUpperCase(), u1.getBoundedSumOfLikes() + u2.getBoundedSumOfLikes());
				}
				));
		
		
		
		/**
		 * Group by type and map result to another type
		 */
		Map<BlogPostType, String> typeByTitles = data.stream().collect(
				Collectors.groupingBy(BlogPost::getType, Collectors.mapping(BlogPost::getTitle, Collectors.joining(","))));
		
		/**
		 * Modify resultant map while group by
		 */
		EnumMap<BlogPostType, List<BlogPost>> postsByType = data.stream().collect(Collectors.groupingBy(BlogPost::getType, () -> new EnumMap(BlogPostType.class), Collectors.toList()));
		
		
		/**
		 * Concurrent grouping
		 */
		ConcurrentMap<BlogPostType, List<BlogPost>> postsPerType = data.parallelStream().collect(Collectors.groupingByConcurrent(BlogPost::getType));
		
		
		
		/**
		 * Group by and counting
		 */
		List<Integer> numbers = Arrays.asList(1,1,2,3,3,3,4,4,5);
		Map<Integer, Long> countByNumbers = numbers.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		
		//Filter and get output only for numbers greater than 3
		countByNumbers = numbers.stream()
				.filter(i -> i > 3)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		
		//In Java 9
		//countByNumbers = numbers.stream()
		//		.collect(Collectors.groupingBy(i -> i, Collectors.filtering(val -> val > 3, Collectors.counting())));

		
		/**
		 * Group by with flat map
		 */
		Map<String, List<List<String>>> postWiseThumbsByAuthor = data.stream()
				.collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.mapping(BlogPost::getThumbs, Collectors.toList())));
		
		

		
		
		
		/**
		 * Stream.map vs Stream.flatMap
		 * map = transform
		 * flatMap = transform + flat
		 */
		List<String> thumbs = data.stream().flatMap(e -> {return e.getThumbs().stream();}).collect(Collectors.toList());
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(thumbs);
		
		
	}

	void prepareData1() {
		data = Arrays.asList(
				new BlogPost("Title 1", "Author 1", 11, BlogPostType.NEWS, "UP"),
				new BlogPost("Title 2", "Author 2", 10, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 3", "Author 3", 10, BlogPostType.GUIDE, "UP"),
				new BlogPost("Title 4", "Author 4", 10, BlogPostType.NEWS, "DOWN"),
				new BlogPost("Title 5", "Author 5", 12, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 6", "Author 1", 12, BlogPostType.GUIDE, "UP"),
				new BlogPost("Title 7", "Author 2", 18, BlogPostType.NEWS, "DOWN"),
				new BlogPost("Title 8", "Author 3", 17, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 9", "Author 4", 19, BlogPostType.GUIDE, "UP", "DOWN"),
				new BlogPost("Title 10", "Author 5", 17, BlogPostType.NEWS, "UP"),
				new BlogPost("Title 11", "Author 1", 11, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 12", "Author 2", 11, BlogPostType.GUIDE, "DOWN"),
				new BlogPost("Title 13", "Author 3", 15, BlogPostType.NEWS, "UP"),
				new BlogPost("Title 14", "Author 4", 17, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 15", "Author 5", 18, BlogPostType.GUIDE, "DOWN"),
				new BlogPost("Title 16", "Author 1", 19, BlogPostType.NEWS, "UP"),
				new BlogPost("Title 17", "Author 2", 14, BlogPostType.REVIEW, "UP", "DOWN"),
				new BlogPost("Title 18", "Author 3", 13, BlogPostType.GUIDE, "UP"),
				new BlogPost("Title 19", "Author 4", 12, BlogPostType.NEWS, "UP", "DOWN"),
				new BlogPost("Title 20", "Author 5", 11, BlogPostType.REVIEW, "UP")
				);
	}
}


enum BlogPostType {
	NEWS, REVIEW, GUIDE
}

class BlogPost implements Serializable {
	private static final long serialVersionUID = 0l;
	
	private String title;
	private String author;
	private int likes;
	private BlogPostType type;
	private List<String> thumbs;
	
	public BlogPost() {
		super();
	}
	public BlogPost(String title, String author, int likes, BlogPostType type) {
		super();
		this.title = title;
		this.author = author;
		this.likes = likes;
		this.type = type;
	}
	
	public BlogPost(String title, String author, int likes, BlogPostType type, String...thumbs) {
		super();
		this.title = title;
		this.author = author;
		this.likes = likes;
		this.type = type;
		this.thumbs = Arrays.asList(thumbs);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public BlogPostType getType() {
		return type;
	}
	public void setType(BlogPostType type) {
		this.type = type;
	}
	public List<String> getThumbs() {
		return thumbs;
	}
	public void setThumbs(List<String> thumbs) {
		this.thumbs = thumbs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogPost other = (BlogPost) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BlogPost [title=" + title + ", author=" + author + ", likes=" + likes + ", type=" + type + "]";
	}
	
	
}

class Tuple {
	private String author;
	private BlogPostType type;

	public Tuple() {
		super();
	}
	public Tuple(String author, BlogPostType type) {
		super();
		this.author = author;
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BlogPostType getType() {
		return type;
	}
	public void setType(BlogPostType type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}

class PostCountTitlesLikesStats {
	private long postCount;
	private String titles;
	private IntSummaryStatistics likeStat;

	public PostCountTitlesLikesStats() {
		super();
	}
	public PostCountTitlesLikesStats(long postCount, String titles, IntSummaryStatistics likeStat) {
		super();
		this.postCount = postCount;
		this.titles = titles;
		this.likeStat = likeStat;
	}
	public long getPostCount() {
		return postCount;
	}
	public void setPostCount(long postCount) {
		this.postCount = postCount;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public IntSummaryStatistics getLikeStat() {
		return likeStat;
	}
	public void setLikeStat(IntSummaryStatistics likeStat) {
		this.likeStat = likeStat;
	}
}

class TitlesBoundedSumOfLikes {
	private String titles;
	private int boundedSumOfLikes;
	public TitlesBoundedSumOfLikes() {
		super();
	}
	public TitlesBoundedSumOfLikes(String titles, int boundedSumOfLikes) {
		super();
		this.titles = titles;
		this.boundedSumOfLikes = boundedSumOfLikes;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public int getBoundedSumOfLikes() {
		return boundedSumOfLikes;
	}
	public void setBoundedSumOfLikes(int boundedSumOfLikes) {
		this.boundedSumOfLikes = boundedSumOfLikes;
	}
}