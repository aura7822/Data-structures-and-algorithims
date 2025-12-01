use rand::Rng;
use std::time::Instant;

/// Merge sort (recursive)
fn merge_sort(arr: &mut [i32]) {
    let n = arr.len();
    if n <= 1 {
        return;
    }
    let mid = n / 2;
    merge_sort(&mut arr[..mid]);
    merge_sort(&mut arr[mid..]);
    merge(arr, mid);
}

/// Merge helper: arr[..mid] and arr[mid..] are sorted
fn merge(arr: &mut [i32], mid: usize) {
    let mut left = arr[..mid].to_vec();
    let mut right = arr[mid..].to_vec();
    let mut i = 0;
    let mut j = 0;
    let mut k = 0;

    while i < left.len() && j < right.len() {
        if left[i] <= right[j] {
            arr[k] = left[i];
            i += 1;
        } else {
            arr[k] = right[j];
            j += 1;
        }
        k += 1;
    }

    while i < left.len() {
        arr[k] = left[i];
        i += 1;
        k += 1;
    }

    while j < right.len() {
        arr[k] = right[j];
        j += 1;
        k += 1;
    }
}

/// Iterative binary search on sorted array
/// Returns Some(index) or None
fn binary_search(arr: &[i32], target: i32) -> Option<usize> {
    let mut left: isize = 0;
    let mut right: isize = (arr.len() as isize) - 1;

    while left <= right {
        let mid = left + (right - left) / 2;
        let mid_usize = mid as usize;
        if arr[mid_usize] == target {
            return Some(mid_usize);
        } else if arr[mid_usize] < target {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    None
}

/// Generate random array of `size` with values in [100, 9099]
fn generate_random_points(size: usize) -> Vec<i32> {
    let mut rng = rand::thread_rng();
    (0..size).map(|_| rng.gen_range(100..=9099)).collect()
}

/// Measure sort and search times (ms), returns (sort_ms, search_ms, found_index_option, target)
fn measure_performance(input_size: usize) -> (f64, f64, Option<usize>, i32) {
    let mut points = generate_random_points(input_size);
    // ensure target exists
    let mut rng = rand::thread_rng();
    let target = points[rng.gen_range(0..input_size)];

    let mut sorted = points.clone();
    let sort_start = Instant::now();
    merge_sort(&mut sorted);
    let sort_duration = sort_start.elapsed();
    let sort_ms = sort_duration.as_secs_f64() * 1000.0;

    let search_start = Instant::now();
    let result_idx = binary_search(&sorted, target);
    let search_duration = search_start.elapsed();
    let search_ms = search_duration.as_secs_f64() * 1000.0;

    (sort_ms, search_ms, result_idx, target)
}

/// Display first up to 20 elements
fn display_array(label: &str, arr: &[i32]) {
    print!("{}: [", label);
    let limit = arr.len().min(20);
    for (i, v) in arr.iter().take(limit).enumerate() {
        if i > 0 {
            print!(", ");
        }
        print!("{}", v);
    }
    if arr.len() > 20 {
        print!(", ...");
    }
    println!("]");
}

fn main() {
    println!("DELIVERY ROUTE OPTIMIZATION ALGORITHM");
    println!("=====================================\n");

    // 1. SAMPLE EXECUTION (10 delivery points)
    println!("1. SAMPLE EXECUTION (10 delivery points)");
    println!("{}", "-".repeat(50));

    let mut sample_points = vec![450, 123, 789, 234, 567, 891, 345, 678, 912, 111];
    display_array("Original delivery points", &sample_points);

    let mut sorted_points = sample_points.clone();
    merge_sort(&mut sorted_points);
    display_array("Sorted delivery points  ", &sorted_points);

    let target = 567;
    println!("\nSearching for delivery point: {}", target);
    match binary_search(&sorted_points, target) {
        Some(idx) => println!("✓ Delivery point {} found at index {}", target, idx),
        None => println!("✗ Delivery point {} not found", target),
    }

    // 2. PERFORMANCE COMPARISON
    println!("\n\n2. PERFORMANCE COMPARISON");
    println!("{}", "-".repeat(50));
    println!("{:<15} {:<20} {:<20}", "Input Size", "Sort Time (ms)", "Search Time (ms)");
    println!("{}", "-".repeat(50));

    let input_sizes = [10usize, 1000usize];
    for &size in &input_sizes {
        let (sort_ms, search_ms, _, _) = measure_performance(size);
        println!("{:<15} {:<20.6} {:<20.6}", size, sort_ms, search_ms);
    }

    // 3. THEORETICAL ANALYSIS
    println!("\n\n3. THEORETICAL ANALYSIS");
    println!("{}", "-".repeat(50));
    let ratio_sort = (1000f64 * (1000f64.ln())) / (10f64 * (10f64.ln()));
    let ratio_search = (1000f64.ln()) / (10f64.ln());
    println!(
        "For input size increase from 10 to 1000:\n• Expected sort time ratio (O(n log n)): ~{:.2}\n• Expected search time ratio (O(log n)): ~{:.2}",
        ratio_sort, ratio_search
    );

    // 4. ADDITIONAL VERIFICATION
    println!("\n\n4. ADDITIONAL VERIFICATION");
    println!("{}", "-".repeat(50));
    let (sort_ms, search_ms, found_opt, target) = measure_performance(10_000);
    println!("Testing with 10,000 delivery points:");
    println!("• Sort time: {:.4} ms", sort_ms);
    println!("• Search time: {:.6} ms", search_ms);
    println!(
        "• Target {} {}",
        target,
        if found_opt.is_some() {
            format!("found successfully at index {}", found_opt.unwrap())
        } else {
            "not found".to_string()
        }
    );
}
