#=
Delivery Route Optimization using Merge Sort and Binary Search
Julia Implementation
=#

using Random
using Printf
using Statistics

# Merge Sort Implementation
function merge_sort!(arr::Vector{Int}, left::Int=1, right::Int=length(arr))
    if left < right
        mid = (left + right) ÷ 2  # Integer division
        merge_sort!(arr, left, mid)
        merge_sort!(arr, mid + 1, right)
        _merge!(arr, left, mid, right)
    end
    return arr
end

function _merge!(arr::Vector{Int}, left::Int, mid::Int, right::Int)
    # Create temporary arrays (1-indexed like Julia arrays)
    left_arr = arr[left:mid]
    right_arr = arr[mid+1:right]
    
    i, j, k = 1, 1, left
    
    # Merge the two arrays
    while i <= length(left_arr) && j <= length(right_arr)
        if left_arr[i] <= right_arr[j]
            arr[k] = left_arr[i]
            i += 1
        else
            arr[k] = right_arr[j]
            j += 1
        end
        k += 1
    end
    
    # Copy remaining elements from left array
    while i <= length(left_arr)
        arr[k] = left_arr[i]
        i += 1
        k += 1
    end
    
    # Copy remaining elements from right array
    while j <= length(right_arr)
        arr[k] = right_arr[j]
        j += 1
        k += 1
    end
end

# Binary Search Implementation (assumes sorted array)
function binary_search(arr::Vector{Int}, target::Int)::Int
    left, right = 1, length(arr)  # Julia uses 1-based indexing
    
    while left <= right
        mid = left + (right - left) ÷ 2
        
        if arr[mid] == target
            return mid
        elseif arr[mid] < target
            left = mid + 1
        else
            right = mid - 1
        end
    end
    
    return -1  # Not found
end

# Performance measurement function
struct PerformanceResult
    sort_time_ms::Float64
    search_time_ms::Float64
    result_index::Int
    target::Int
    input_size::Int
end

function measure_performance(input_size::Int)::PerformanceResult
    # Generate random delivery points (100 to 9999)
    delivery_points = rand(100:9999, input_size)
    
    # Ensure target exists in the array
    target = rand(delivery_points)
    
    # Measure sorting time
    sorted_array = copy(delivery_points)
    sort_start_time = time_ns()
    merge_sort!(sorted_array)
    sort_end_time = time_ns()
    sort_time_ms = (sort_end_time - sort_start_time) / 1_000_000.0
    
    # Measure searching time
    search_start_time = time_ns()
    result_index = binary_search(sorted_array, target)
    search_end_time = time_ns()
    search_time_ms = (search_end_time - search_start_time) / 1_000_000.0
    
    return PerformanceResult(sort_time_ms, search_time_ms, result_index, target, input_size)
end

# Display array helper function (truncates if large)
function display_array(label::String, arr::Vector{Int})
    print(label, ": [")
    n = min(length(arr), 20)
    for i in 1:n
        print(arr[i])
        i < n && print(", ")
    end
    if length(arr) > 20
        print(", ...")
    end
    println("] (", length(arr), " elements)")
end

# Main execution
function main()
    println("="^60)
    println("DELIVERY ROUTE OPTIMIZATION ALGORITHM (Julia)")
    println("="^60)
    println()
    
    # Sample input (10 delivery points)
    sample_points = [450, 123, 789, 234, 567, 891, 345, 678, 912, 111]
    
    println("1. SAMPLE EXECUTION (10 delivery points)")
    println("-"^50)
    display_array("Original delivery points", sample_points)
    
    # Create a copy for sorting
    sorted_points = copy(sample_points)
    merge_sort!(sorted_points)
    display_array("Sorted delivery points  ", sorted_points)
    
    # Search for specific point
    target = 567
    result = binary_search(sorted_points, target)
    println("\nSearching for delivery point: ", target)
    if result != -1
        println("✓ Delivery point ", target, " found at index ", result)
        println("  Value at index ", result, ": ", sorted_points[result])
    else
        println("✗ Delivery point ", target, " not found")
    end
    
    # Verify sorting is correct
    is_sorted_correctly = issorted(sorted_points)
    println("\nSorting verification: ", is_sorted_correctly ? "✓ PASS" : "✗ FAIL")
    
    # Performance comparison
    println("\n\n2. PERFORMANCE COMPARISON")
    println("-"^50)
    println(@sprintf("%-15s %-20s %-20s", "Input Size", "Sort Time (ms)", "Search Time (ms)"))
    println("-"^50)
    
    input_sizes = [10, 1000, 10000]
    results = []
    
    for size in input_sizes
        # Run multiple times for more accurate timing
        trial_times_sort = Float64[]
        trial_times_search = Float64[]
        
        for trial in 1:5  # 5 trials for better accuracy
            result = measure_performance(size)
            push!(trial_times_sort, result.sort_time_ms)
            push!(trial_times_search, result.search_time_ms)
        end
        
        avg_sort_time = mean(trial_times_sort)
        avg_search_time = mean(trial_times_search)
        final_result = measure_performance(size)  # One more for the result
        
        println(@sprintf("%-15d %-20.6f %-20.6f", 
            size, avg_sort_time, avg_search_time))
        push!(results, (size, avg_sort_time, avg_search_time))
    end
    
    # Theoretical analysis
    println("\n\n3. THEORETICAL ANALYSIS")
    println("-"^50)
    println("Time Complexity Analysis:")
    println("• Merge Sort: O(n log n) best/avg/worst case")
    println("• Binary Search: O(log n) best/avg/worst case")
    println()
    
    # Calculate actual ratios
    if length(results) >= 2
        small_size, small_sort, small_search = results[1]
        large_size, large_sort, large_search = results[2]
        
        sort_ratio = large_sort / small_sort
        search_ratio = large_search / small_search
        
        theoretical_sort_ratio = (large_size * log2(large_size)) / (small_size * log2(small_size))
        theoretical_search_ratio = log2(large_size) / log2(small_size)
        
        println("Performance Ratios (", large_size, " / ", small_size, "):")
        println(@sprintf("• Actual Sort Ratio:     %.2fx", sort_ratio))
        println(@sprintf("• Theoretical (n log n): %.2fx", theoretical_sort_ratio))
        println(@sprintf("• Actual Search Ratio:   %.2fx", search_ratio))
        println(@sprintf("• Theoretical (log n):   %.2fx", theoretical_search_ratio))
    end
    
    # Memory usage analysis
    println("\n\n4. MEMORY ANALYSIS")
    println("-"^50)
    println("Space Complexity:")
    println("• Merge Sort: O(n) additional space")
    println("• Binary Search: O(1) space")
    
    # Demonstrate with actual memory allocation
    println("\nDemonstrating with 1000 elements:")
    test_array = rand(100:9999, 1000)
    
    # Memory before sort
    mem_before = Base.summarysize(test_array)
    test_array_sorted = copy(test_array)
    
    # Force garbage collection for accurate measurement
    GC.gc()
    
    merge_sort!(test_array_sorted)
    mem_after = Base.summarysize(test_array_sorted)
    
    println(@sprintf("  Memory used by array: %.2f KB", mem_before / 1024))
    println(@sprintf("  Memory after sorting: %.2f KB", mem_after / 1024))
    println(@sprintf("  Additional temporary memory: ~%.2f KB (during merge))", mem_before / 1024))
    
    # Compare with Julia's built-in sort
    println("\n\n5. COMPARISON WITH JULIA BUILT-IN SORT")
    println("-"^50)
    
    # Time Julia's sort algorithm
    large_array = rand(1:10000, 10000)
    
    # Custom merge sort
    custom_array = copy(large_array)
    custom_start = time_ns()
    merge_sort!(custom_array)
    custom_time = (time_ns() - custom_start) / 1_000_000.0
    
    # Julia's built-in sort
    builtin_array = copy(large_array)
    builtin_start = time_ns()
    sort!(builtin_array)
    builtin_time = (time_ns() - builtin_start) / 1_000_000.0
    
    println(@sprintf("For 10,000 elements:"))
    println(@sprintf("• Custom Merge Sort: %.3f ms", custom_time))
    println(@sprintf("• Julia Built-in Sort: %.3f ms", builtin_time))
    println(@sprintf("• Ratio (Custom/Built-in): %.2fx", custom_time / builtin_time))
    
    # Verify both produce same result
    arrays_equal = custom_array == builtin_array
    println("• Results identical: ", arrays_equal ? "✓" : "✗")
    
    println("\n" * "="^60)
    println("END OF ANALYSIS")
    println("="^60)
end

# Run the main function
if abspath(PROGRAM_FILE) == @__FILE__
    main()
end